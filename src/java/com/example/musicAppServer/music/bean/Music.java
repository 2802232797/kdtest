package com.example.musicAppServer.music.bean;

import java.sql.Date;

public class Music {
    private Integer id;
    private String song_name;
    private String singer;
    private String mp3_file_path;
    private String cover_image_path;
    private String lyrics_path;
    private Date created_at;
    private Date updated_at;
    private String introduction;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public Music() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMp3_file_path() {
        return mp3_file_path;
    }

    public void setMp3_file_path(String mp3_file_path) {
        this.mp3_file_path = mp3_file_path;
    }

    public String getCover_image_path() {
        return cover_image_path;
    }

    public void setCover_image_path(String cover_image_path) {
        this.cover_image_path = cover_image_path;
    }

    public String getLyrics_path() {
        return lyrics_path;
    }

    public void setLyrics_path(String lyrics_path) {
        this.lyrics_path = lyrics_path;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", song_name='" + song_name + '\'' +
                ", singer='" + singer + '\'' +
                ", mp3_file_path='" + mp3_file_path + '\'' +
                ", cover_image_path='" + cover_image_path + '\'' +
                ", lyrics_path='" + lyrics_path + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
