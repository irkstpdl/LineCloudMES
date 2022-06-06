package com.lc.view.api.notifications;

import java.util.List;

public class NotificationContainer {

    private boolean sound;

    public List<Notification> notifications;

    public boolean isSound() {
        return sound;
    }

    private void setSound() {
        this.sound = sound;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
