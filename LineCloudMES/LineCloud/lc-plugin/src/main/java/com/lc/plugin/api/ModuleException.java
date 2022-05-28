package com.lc.plugin.api;

import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * Basic module exception
 *
 * @since 0.1.0
 */
public class ModuleException extends RuntimeException {

    private static final long serialVersionUID = -5382056547567036558L;

    public ModuleException(final String pluginIdentifier,final String moduleType, final Throwable cause) {
        super(ModuleException.createMessage(pluginIdentifier,moduleType,null,cause,null),cause);
    }

    public ModuleException(final String pluginIdentifier, final String moduleType, final String message) {
        super(ModuleException.createMessage(pluginIdentifier,moduleType,null,null,message));
    }

    public ModuleException(final String pluginIdentifier, final String moduleType, final Element element, final Throwable cause) {
        super(ModuleException.createMessage(pluginIdentifier,moduleType,element,cause,null),cause);
    }

    private static String createMessage(String pluginIdentifier, String moduleType, Element element,
           final Throwable cause, final String message) {
        StringBuilder builder = new StringBuilder("[PLUGIN:");
        builder.append(pluginIdentifier);
        builder.append(",");
        if (element ==null) {
            builder.append("MODULE:");
            builder.append(moduleType);
        } else {
            builder.append("ELEMENT: ");
            XMLOutputter outputter = new XMLOutputter();
            builder.append(outputter.outputString(element));

        }
        builder.append("]");
        if (cause ==null) {
            builder.append(message);
        } else {
            builder.append(cause.getMessage());
        }
        return builder.toString();
    }
}
