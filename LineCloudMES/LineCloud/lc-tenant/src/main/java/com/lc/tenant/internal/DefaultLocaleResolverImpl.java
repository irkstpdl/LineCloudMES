package com.lc.tenant.internal;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.lc.tenant.api.DefaultLocaleResolver;

@Service
public final class DefaultLocaleResolverImpl implements DefaultLocaleResolver {

    private static final Locale PL = new Locale("pl");

    private static final Locale EN = new Locale("en");

    @Value("${defaultLocale}")
    private String locale;

    public Locale getDefaultLocale() {
        if ("pl".equalsIgnoreCase(locale)) {
            return PL;
        }
        if ("en".equalsIgnoreCase(locale)) {
            return EN;
        }

        return LocaleContextHolder.getLocale();
    }
}
