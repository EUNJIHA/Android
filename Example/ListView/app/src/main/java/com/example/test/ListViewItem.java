package com.example.test;

import android.graphics.drawable.Drawable;

public class ListViewItem {

    private Drawable room_profile;
    private String room_title;
    private String room_content;
    private String room_time;


    public Drawable getRoom_profile() {
        return room_profile;
    }

    public String getRoom_title() {
        return room_title;
    }

    public String getRoom_content() {
        return room_content;
    }

    public String getRoom_time() {
        return room_time;
    }

    public void setRoom_profile(Drawable room_profile) {
        this.room_profile = room_profile;
    }

    public void setRoom_title(String room_title) {
        this.room_title = room_title;
    }

    public void setRoom_content(String room_content) {
        this.room_content = room_content;
    }

    public void setRoom_time(String room_time) {
        this.room_time = room_time;
    }
}
