package com.lc.view.api.exception;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class ExceptionInfo {

    private final String messageHeader;

    private final String messageExplanation;

    private final String[] messageExplanationArgs;


    public ExceptionInfo(final String messageHeader, final String messageExplanation, final String[] messageExplanationArgs) {
        this.messageHeader = messageHeader;
        this.messageExplanation = messageExplanation;
        if (ArrayUtils.isEmpty(messageExplanationArgs)) {
            this.messageExplanationArgs = ArrayUtils.EMPTY_STRING_ARRAY;
        } else {
            this.messageExplanationArgs = messageExplanationArgs;
        }

    }

    public String getMessageHeader() {
        return messageHeader;
    }

    public String getMessageExplanation() {
        return messageExplanation;
    }

    public String[] getMessageExplanationArgs() {
        return Arrays.copyOf(messageExplanationArgs,messageExplanationArgs.length);
    }
}
