package com.ccproject.cloud.cloudclubbing;

import java.util.Date;

/**
 * Created by priteshasvinetsakou on 16/12/14.
 */
public class Newsfeeds {

    public int             id;
    public String          flowMessage;
    public Date            date;
    public String          autorName;
    public int             photoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlowMessage() {
        return flowMessage;
    }

    public void setFlowMessage(String flowMessage) {
        this.flowMessage = flowMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }


}
