package com.lc.view.api.crud;

import java.util.Locale;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import com.lc.view.api.ViewDefinitionState;

/**
 * 访问高级控制器功能的服务。在创建 Spring MVC Controller 并希望扩展 lc 框架标准机制时应该使用它。
 * <p>
 * Some example of how CrudService can be used (inside Spring MVC Controller): <blockquote>
 *
 * <pre>
 *
 *
 *
 * &#064;RequestMapping(value = &quot;examplePluginPages/infoPage&quot;, method = RequestMethod.GET)
 * public ModelAndView getInfoPageView(@RequestParam final Map&lt;String, String&gt; arguments, final Locale locale) {
 *     arguments.put(&quot;popup&quot;, &quot;true&quot;);
 *     ModelAndView mav = crudService.prepareView(&quot;examplePlugin&quot;, &quot;exampleView&quot;, arguments, locale);
 *
 *     // some ModelAndView modifications, like:
 *     mav.addObject(&quot;headerClass&quot;, &quot;successHeader&quot;);
 *
 *     return mav;
 * }
 *
 * </pre>
 *
 * </blockquote>
 *
 * <p>
 *
 * @since 0.1.0
 *
 */
public interface CrudService {

    /**
     * Generates Spring ModelAndView for specified view.
     *
     * @param pluginIdentifier
     *            identifier of plugin
     * @param viewName
     *            name of view
     * @param arguments
     *            map of arguments
     * @param locale
     *            current locale
     * @return generated ModelAndView
     */
    ModelAndView prepareView(String pluginIdentifier,String viewName, Map<String,String> arguments,Locale locale);

    /**
     * Performs event on specified view and returns the result
     *
     * @param pluginIdentifier
     *            identifier of plugin
     * @param viewName
     *            name of view
     * @param body
     *            request json body
     * @param locale
     *            current locale
     * @return JSONObject generated by performing event
     * @deprecated
     * @see #invokeEventAndRenderView(String, String, JSONObject, Locale)
     */
    @Deprecated
    JSONObject performEvent(String pluginIdentifier, String viewName, JSONObject body, Locale locale);

    /**
     * Performs event on specified view and returns the result
     *
     * @param pluginIdentifier
     *            identifier of plugin
     * @param viewName
     *            name of view
     * @param body
     *            request json body
     * @param locale
     *            current locale
     * @return JSONObject generated by performing event
     */
    JSONObject invokeEventAndRenderView(String pluginIdentifier, String viewName, JSONObject body, Locale locale);

    /**
     * Performs event on specified view and returns view definition state.
     *
     * @param pluginIdentifier
     *            identifier of plugin
     * @param viewName
     *            name of view
     * @param body
     *            request json body
     * @param locale
     *            current locale
     * @return view definition state
     * @since 0.1.1
     */
    ViewDefinitionState invokeEvent(String pluginIdentifier, String viewName, JSONObject body, Locale locale);

    /**
     * Render given view definition state.
     *
     * @param state
     *            view definition state
     * @return JSONObject
     * @since 0.1.1
     */
    JSONObject renderView(ViewDefinitionState state);
}
