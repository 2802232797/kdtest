package com.example.musicAppServer.music.service.impl;

import com.example.musicAppServer.music.bean.Music;
import com.example.musicAppServer.music.dao.MusicDao;
import com.example.musicAppServer.music.dao.impl.MusicDaoImpl;
import com.example.musicAppServer.music.service.MusicService;

import java.sql.SQLException;
import java.util.List;

public class MusicServiceImpl implements MusicService {
    private final MusicDao musicDao = new MusicDaoImpl();
    @Override
    public int add(Music music) throws SQLException {
        return musicDao.add(music);
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        return musicDao.deleteById(id);
    }

    @Override
    public int update(Music music) throws SQLException {
        return musicDao.update(music);
    }

    @Override
    public List<Music> findByName(String name) throws SQLException {
        return musicDao.findByName(name);
    }

    @Override
    public List<Music> findByArtist(String artist) throws SQLException {
        return musicDao.findByArtist(artist);
    }

    @Override
    public Music findById(Integer id) throws SQLException {
        return musicDao.findById(id);
    }

    @Override
    public List<Music> findAll() throws SQLException {
        return musicDao.findAll();
    }
}
