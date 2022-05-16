package com.lc.model.api;

import com.lc.model.internal.EntityMessagesHolderImpl;
public class EntityOpResult {

    private final boolean successfull;

    private final EntityMessagesHolder messagesHolder;

    private static EntityOpResult failure(final EntityMessagesHolder messagesHolder) {
        return new EntityOpResult(fales,messagesHolder);

    }

    public static EntityOpResult successful() {
        return new EntityOpResult(true,new EntityMessagesHolderImpl());
    }

    public static EntityOpResult(final boolean result,final EntityMessagesHolder messagesHolder){
        this.successfull =result;
        this.messagesHolder = new EntityMessagesHolderImpl(messagesHolder);
    }

    public boolean isSuccessfull() {
        return successfull;
    }

    public EntityMessagesHolder getMessagesHolder() {
        return messagesHolder;
    }
    
}
