package com.lc.model.internal;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
public abstract class AbstractModelXmlConverter {

    public static enum FieldsTag {
        PRIORITY, INTEGER, STRING, TEXT, DECIMAL, DATETIME, DATE, BOOLEAN, BELONGSTO, HASMANY, TREE, ENUM, DICTIONARY, PASSWORD, FILE, MANYTOMANY
    }

    public static enum HooksTag {
        ONVIEW, ONCREATE, ONUPDATE, ONSAVE, ONCOPY, VALIDATESWITH, ONDELETE
    }

    public static enum OtherTag {
        IDENTIFIER, MASTERMODEL
    }

    protected static enum FieldTag {
        VALIDATESLENGTH, VALIDATESUNSCALEDVALUE, VALIDATESSCALE, VALIDATESRANGE, VALIDATESWITH, VALIDATESREGEX
    }
    protected static final String TAG_MODEL = "model";

    protected static final String TAG_FIELDS = "fields";

    protected static final String TAG_PLUGIN= "plugin";

    protected static final String TAG_JOIN_FIELD ="joinFidld";

    protected String getPluginIdentifier(final XMLStreamReader reader) {
        return getStringAttribute(reader,"plugin");
    }
}
