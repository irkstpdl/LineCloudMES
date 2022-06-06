package com.lc.view.api.notifications;

public class Notification {

    private final String message;

    public final NotificationType type;

    public final boolean sound;

    public final boolean autoClose;


    public Notification(final String message, final NotificationType type) {
        this.message = message;
        this.type = type;
        this.sound = false;
        this.autoClose = true;
    }

    public Notification(final NotificationType type, String message, boolean autoClose) {
        this.type = type;
        this.message = message;
        this.sound = false;
        this.autoClose = autoClose;
    }

    public Notification(final NotificationType type, final String message, boolean sound, boolean autoClose) {
        this.type = type;
        this.message = message;
        this.sound = sound;
        this.autoClose = autoClose;
    }

    final String getMessage() {
        return message;
    }

    final NotificationType getType() {
        return type;
    }

    final boolean isSound() {
        return sound;
    }

    final boolean isAutoClose() {
        return autoClose;
    }
}
