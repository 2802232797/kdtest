package com.example.musicAppServer.user.utils;

import com.alibaba.fastjson.JSON;
import com.example.musicAppServer.user.server.ResultBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Json转换工具
 */
public class JsonUtils {
    /**
     * 响应结果方法
     */
    public static void printResult(HttpServletResponse response, ResultBean obj) throws IOException{
        response.setContentType("application/json;charset=utf-8");
        JSON.writeJSONString(response.getWriter(),obj.getData());
    }
    /**
     * 把json转成对象
     */
    public static <T> T parseJSON2Object(HttpServletRequest request,Class<T> tClass) throws IOException{
        //把表单数据转换成对象
        return JSON.parseObject(request.getInputStream(),tClass);
    }
}
