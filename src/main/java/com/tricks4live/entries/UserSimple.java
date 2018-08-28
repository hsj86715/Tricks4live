package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize
public class UserSimple implements Serializable{
    private Long id;//自身ID
    private String nickName;
    private String avatar;

    public UserSimple() {
    }

    public UserSimple(Long id) {
        this.id = id;
    }

    public UserSimple(String nickName, String avatar) {
        this.nickName = nickName;
        this.avatar = avatar;
    }

    public UserSimple(Long id, String nickName, String avatar) {
        this.id = id;
        this.nickName = nickName;
        this.avatar = avatar;
    }

    public UserSimple(User user) {
        this.id = user.getId();
        this.nickName = user.getNickName();
        this.avatar = user.getAvatar();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserSimple{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
