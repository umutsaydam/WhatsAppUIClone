package com.example.whatsappcloneui.Models;

import android.widget.ImageView;

public class Message {
    int profilePhoto;
    String sender;
    String message;
    String time;
    int countOfMessage;

    public Message(int profilePhoto, String sender, String message, String time, int countOfMessage) {
        this.profilePhoto = profilePhoto;
        this.sender = sender;
        this.message = message;
        this.time = time;
        this.countOfMessage = countOfMessage;
    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCountOfMessage() {
        return countOfMessage;
    }

    public void setCountOfMessage(int countOfMessage) {
        this.countOfMessage = countOfMessage;
    }
}
