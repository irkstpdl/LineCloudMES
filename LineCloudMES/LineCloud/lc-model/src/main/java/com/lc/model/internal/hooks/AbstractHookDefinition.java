package com.lc.model.internal.hooks;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Abstract superclass which provides some common building-blocks for Java hooks.
 *
 * @author PhiliphG
 * @since 1.4
 */
public abstract class AbstractHookDefinition {
    private final String pluginIdentifier;

    private final String className;

    private final String methodName;

    private final Object bean;

    private final Method method;


    protected AbstractHookDefinition(final String className, final String methodName,
                                     final String pluginIdentifier, final ApplicationContext applicationContext ) throws HookInitializationException {
        this.pluginIdentifier = pluginIdentifier;
        this.className = className;
        this.methodName = methodName;

        Class<?> clazz = getHookClass(className);
        this.bean = getHookBean(clazz,applicationContext);
        this.method = getMethod(clazz, methodName);

        checkHookMethodModifiers();
    }

    private Class<?> getHookClass(final String hookClassName) throws HookInitializationException {
        if (StringUtils.isBlank(className)) {
            throw  new HookInitializationException(className,methodName,"Hook class name cannot be empty");

        } try {
            return Thread.currentThread().getContextClassLoader().loadClass(hookClassName);
        } catch (ClassNotFoundException e) {
            throw new HookInitializationException(className,methodName,"Failed to find class '"
            +hookClassName + "', please make sure that there is no typo", e);
        }
    }

    private Object getHookBean(Class<?> clazz, ApplicationContext applicationContext)
            throws HookInitializationException {
        Object hookBean = applicationContext.getBean(clazz);
        if (hookBean == null) {
            throw new HookInitializationException(
                    className,
                    methodName,
                    "Failed to find bean for class '"
                            + clazz.getCanonicalName()
                            + "', please make sure that there is no typo, class have @Service or @Component annotation and its package is registered in the Spring component-scan feature");

            )
        }
        return hookBean;
    }



    private void checkHookMethodModifiers() throws HookInitializationException {
        if (!Modifier.isPublic(method.getModifiers())) {
            throw new HookInitializationException(className,methodName,"Hook method '"
                    + method.getDeclaringClass().getCanonicalName() + "#" + method.getName()
                    + "' has invalid visibility, must be public");
        }
    }


    protected abstract Class<?>[] getParameterTypes();

    private Method getMethod(Class<?> clazz,final String methodName)
    throws HookInitializationException {
        if (StringUtils.isBlank(methodName)) {
            throw new HookInitializationException(className,methodName,"Hook method name cannot be empty");

        } try {
            return clazz.getMethod(methodName,getParameterTypes());
        } catch (SecurityException e) {
            throw new HookInitializationException(className, methodName, "Failed to access hook method '"
                    + clazz.getCanonicalName() + "#" + methodName + "'", e);
        } catch (NoSuchMethodException e) {
            throw new HookInitializationException(className, methodName, "Failed to find hook method '"
                    + clazz.getCanonicalName() + "#" + methodName
                    + "', please make sure that there is no typo and parameters' types are valid ("
                    + Arrays.toString(getParameterTypes()) + ")", e);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() !=getClass()) {
            return false;
        }
        AbstractHookDefinition rhs = (AbstractHookDefinition) obj;
        return EqualsBuilder().append(this.className, rhs.className).append(this.methodName, rhs.methodName)
                .append(this.pluginIdentifier, rhs.pluginIdentifier).isEquals();

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(className).append(methodName).append(pluginIdentifier).toHashCode();
    }
}
