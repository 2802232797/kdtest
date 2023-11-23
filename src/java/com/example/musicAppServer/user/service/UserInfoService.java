package com.example.musicAppServer.user.service;

import com.example.musicAppServer.user.bean.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserInfoService {
    int add(UserInfo userInfo) throws SQLException;
    int deleteById(Integer id) throws SQLException;
    int update(UserInfo userInfo) throws SQLException;
    int updateLevelById(Integer level, Integer id) throws SQLException;
    UserInfo findById(Integer id) throws  SQLException;
    List<UserInfo> findByName(String name) throws  SQLException;
    UserInfo findByPhone(String phone) throws SQLException;
}
