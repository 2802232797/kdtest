package com.example.musicAppServer.music.service;

import com.example.musicAppServer.music.bean.Music;

import java.sql.SQLException;
import java.util.List;

public interface MusicService {
    int add(Music music) throws SQLException;
    int deleteById(Integer id) throws SQLException;
    int update(Music music) throws SQLException;

    List<Music> findByName(String name) throws SQLException;
    List<Music> findByArtist(String artist) throws  SQLException;
    Music findById(Integer id) throws SQLException;
    List<Music> findAll() throws SQLException;
}
