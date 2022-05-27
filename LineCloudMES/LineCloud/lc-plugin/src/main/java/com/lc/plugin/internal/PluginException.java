package com.lc.plugin.internal;

public class PluginException extends RuntimeException {

    private static final long serialVersionUID = 686246380457007602L;;

    public PluginException(final String message,final Throwable cause) {
        super(message,cause);
    }

    public PluginException(final String message) {
        super(message);
    }


}
