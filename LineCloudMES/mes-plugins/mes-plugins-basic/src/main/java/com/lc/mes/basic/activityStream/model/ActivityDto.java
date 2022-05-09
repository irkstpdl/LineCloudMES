package com.lc.mes.basic.activityStream.model;

import java.util.Date;

public class ActivityDto {

    private Long id;

    private String message;

    private String type;

    private boolean viewed;

    private Date date;

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private String getMessage() {
        return message;
    }

    private void setMessage() {
        this.message = message;
    }

    private String getType() {
        return type;
    }

    public void  setType() {
        this.type = type;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public Date getDate() {
        return (date == null) ? null : new Date(date.getTime());
    }

    public void setDate(final Date date) {
        this.date = (date == null) ? null : new Date(date.getTime());
    }
}
