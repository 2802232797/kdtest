package com.example.musicAppServer.user.server;

import java.io.Serializable;

/**
 * 服务器管理类：用于管理后端数据到前端的管理者
 * 1、加一个序列化
 * 2、定义相应的属性
 * 3、添加构造方法
 * 4、添加set和get方法
 * 5、添加一个toString方法用于测试
 */
public class ResultBean implements Serializable {
    //定义服务器状态
    private Boolean flag;
    //定义data，用于存数据
    private Object data;
    //定义一个错误信息变量
    private String errorMsg;
    //添加构造方法
    public ResultBean(){}

    public ResultBean(Boolean flag) {
        this.flag = flag;
    }

    public ResultBean(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultBean(Boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public ResultBean(Boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }
    //添加set和get方法

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    //添加一个toString方法

    @Override
    public String toString() {
        return "ResultBean{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
