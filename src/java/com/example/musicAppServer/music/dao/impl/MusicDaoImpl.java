package com.example.musicAppServer.music.dao.impl;

import com.example.musicAppServer.music.bean.Music;
import com.example.musicAppServer.music.dao.MusicDao;
import com.example.musicAppServer.user.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class MusicDaoImpl implements MusicDao {
    private final QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public int add(Music music) throws SQLException {
        String sql = "insert into music(song_name,artist,mp3_file_path,cover_image_path) values(?,?,?,?)";
        Object[] params = {
                music.getSong_name(),
                music.getSinger(),
                music.getMp3_file_path(),
                music.getCover_image_path()
        };
        return queryRunner.update(sql, params);
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql = "delete from music where id=?";
        return queryRunner.update(sql, id);
    }

    @Override
    public int update(Music music) throws SQLException {
        String sql = "update music set song_name=?," +
                "artist=?," +
                "mp3_file_path=?," +
                "cover_image_path=?," +
                "lyrics_path=?,updated_at=CURRENT_TIMESTAMP where id=?";
        Object[] params = {
                music.getSong_name(),
                music.getSinger(),
                music.getMp3_file_path(),
                music.getCover_image_path(),
                music.getLyrics_path(),
                music.getId()
        };
        return queryRunner.update(sql, params);
    }

    @Override
    public List<Music> findByName(String name) throws SQLException {
        String sql = "select * from music where song_name like ?";
        Object[] params = {
                '%'+name+'%'
        };
        return queryRunner.query(sql, new BeanListHandler<>(Music.class), params);
    }

    @Override
    public List<Music> findByArtist(String artist) throws SQLException {
        String sql = "select * from music where artist like ?";
        Object[] params = {
                '%'+artist+'%'
        };
        return queryRunner.query(sql, new BeanListHandler<>(Music.class), params);
    }

    @Override
    public Music findById(Integer id) throws SQLException {
        String sql = "select * from music where id=?";
        return queryRunner.query(sql, new BeanHandler<>(Music.class), id);
    }

    @Override
    public List<Music> findAll() throws SQLException {
        String sql = "select * from music";
        return queryRunner.query(sql, new BeanListHandler<>(Music.class));
    }
}
