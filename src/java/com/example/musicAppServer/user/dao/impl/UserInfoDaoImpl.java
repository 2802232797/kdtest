package com.example.musicAppServer.user.dao.impl;

import com.example.musicAppServer.user.bean.UserInfo;
import com.example.musicAppServer.user.dao.UserInfoDao;
import com.example.musicAppServer.user.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {
    private final QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public int add(UserInfo userInfo) throws SQLException {
        String sql = "insert into userinfo(name,phone) values(?,?)";
        Object[] params = {
                userInfo.getPhone(),
                userInfo.getPhone()
        };
        return queryRunner.update(sql, params);
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql = "delete from userinfo where pk_id=?";
        return queryRunner.update(sql, id);
    }

    @Override
    public int update(UserInfo userInfo) throws SQLException {
        String sql = "update userinfo set name=?,introduction=?,modified_time=now() where pk_id=?";
        Object[] params = {
                userInfo.getName(),
                userInfo.getIntroduction(),
                userInfo.getPk_id()
        };
        return queryRunner.update(sql, params);
    }

    @Override
    public int updateLevelById(Integer level, Integer id) throws SQLException {
        String sql = "update userinfo set level=?,modified_time=now() where pk_Id=?";
        Object[] params = {
                level,
                id
        };
        return queryRunner.update(sql, params);
    }

    @Override
    public UserInfo findById(Integer id) throws SQLException {
        String sql = "select * from userinfo where pk_id=?";
        return queryRunner.query(sql, new BeanHandler<>(UserInfo.class), id);
    }

    @Override
    public List<UserInfo> findByName(String name) throws SQLException {
        String sql = "select * from userinfo where name like ?";
        Object[] params = {
                '%'+name+'%'
        };
        return queryRunner.query(sql, new BeanListHandler<>(UserInfo.class), params);
    }

    @Override
    public UserInfo findByPhone(String phone) throws SQLException {
        String sql = "select * from userinfo where phone=?";
        Object[] params = {
                phone
        };
        return queryRunner.query(sql, new BeanHandler<>(UserInfo.class), params);
    }
}
