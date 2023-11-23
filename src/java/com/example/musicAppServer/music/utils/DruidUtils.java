package com.example.musicAppServer.music.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DruidUtils {
    private static DataSource dataSource;
    static {
        try {
            Properties props = new Properties();
            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("application.properties");
            props.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(props);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource() {
        return dataSource;
    }
}
