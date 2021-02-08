package com.terry.retrofit_callback.http;

import com.google.gson.annotations.SerializedName;

public class User {
    public long id;
    @SerializedName("login")
    public String nick;
    public String name;
    public long followers;
    public long following;

    public long getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public String getName() {
        return name;
    }

    public long getFollowers() {
        return followers;
    }

    public long getFollowing() {
        return following;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", name='" + name + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }
}
