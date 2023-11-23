package com.example.musicAppServer.user.service.impl;

import com.example.musicAppServer.user.bean.UserInfo;
import com.example.musicAppServer.user.dao.UserInfoDao;
import com.example.musicAppServer.user.dao.impl.UserInfoDaoImpl;
import com.example.musicAppServer.user.service.UserInfoService;

import java.sql.SQLException;
import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoDao userInfoDao = new UserInfoDaoImpl();
    @Override
    public int add(UserInfo userInfo) throws SQLException {
        return userInfoDao.add(userInfo);
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        return userInfoDao.deleteById(id);
    }

    @Override
    public int update(UserInfo userInfo) throws SQLException {
        return userInfoDao.update(userInfo);
    }

    @Override
    public int updateLevelById(Integer level, Integer id) throws SQLException {
        return userInfoDao.updateLevelById(level, id);
    }

    @Override
    public UserInfo findById(Integer id) throws SQLException {
        return userInfoDao.findById(id);
    }

    @Override
    public List<UserInfo> findByName(String name) throws SQLException {
        return userInfoDao.findByName(name);
    }

    @Override
    public UserInfo findByPhone(String phone) throws SQLException {
        return userInfoDao.findByPhone(phone);
    }
}
