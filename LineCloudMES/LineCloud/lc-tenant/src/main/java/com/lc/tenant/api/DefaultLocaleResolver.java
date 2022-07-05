package com.lc.tenant.api;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 用于解析语言环境的服务。
 *
 * @since 1.0.7
 */

public interface DefaultLocaleResolver {

    /**
     * 此方法用于支持在您无法使用 Spring 的 {@link LocaleContextHolder} 获取语言环境时获取它们，例如在系统或插件启动期间。
     * 此方法与 {@link LocaleContextHolder#getLocale()}之间的主要区别在于:
     * 第二个方法返回当前 linecloud 用户的语言环境，由他们在登录期间选择。
     *
     * @return default {@link Locale} for current instance/tenant
     */
    Locale getDefaultLocale();
}
