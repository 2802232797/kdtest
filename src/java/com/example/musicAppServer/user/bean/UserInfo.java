package com.example.musicAppServer.user.bean;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private Integer pk_id;
    private String name;
    private String phone;
    private Integer level;
    private String introduction;
    private Date create_time;
    private Date modified_time;

    public UserInfo() {
    }

    public UserInfo(String phone) {
        this.phone = phone;
    }

    public UserInfo(Integer pk_id, String name, String introduction) {
        this.pk_id = pk_id;
        this.name = name;
        this.introduction = introduction;
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "pk_id=" + pk_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", level=" + level +
                ", introduction='" + introduction + '\'' +
                ", create_time=" + create_time +
                ", modified_time=" + modified_time +
                '}';
    }
}
