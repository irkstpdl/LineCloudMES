package com.lc.model.internal.api;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.dao.support.PersistenceExceptionTranslationInterceptor;

public interface DynamicSessionFactoryBean extends BeanClassLoaderAware,FactoryBean<SessionFactory>, InitializingBean, DisposableBean, PersistenceExceptionTranslator{

    void initialize(Resource[] hbms);
}
