package com.example.musicAppServer.user.web;

import com.example.musicAppServer.user.bean.UserInfo;
import com.example.musicAppServer.user.service.UserInfoService;
import com.example.musicAppServer.user.service.impl.UserInfoServiceImpl;
import com.example.musicAppServer.user.utils.GsonUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserInfoServlet", value = "/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    private final UserInfoService userInfoService = new UserInfoServiceImpl();
    private UserInfo userInfo;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userAction = request.getParameter("action");
        try {
            Class<?extends Servlet> cls = this.getClass();
            Method method = cls.getDeclaredMethod(userAction, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = request.getParameter("phone");
        if (phone.length() > 0) {
            phone = URLDecoder.decode(phone, "UTF-8");
        }
        userInfo = new UserInfo(phone);
        try {
            response.getWriter().write(userInfoService.add(userInfo));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            response.getWriter().write(userInfoService.deleteById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        if (name.length() > 0) {
            name = URLDecoder.decode(name, "UTF-8");
        }
        String introduction = request.getParameter("introduction");
        if (introduction.length() > 0) {
            introduction = URLDecoder.decode(introduction, "UTF-8");
        }
        userInfo = new UserInfo(id, name, introduction);
        try {
            response.getWriter().write(userInfoService.update(userInfo));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLevelById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer level = Integer.valueOf(request.getParameter("level"));
        try {
            response.getWriter().write(userInfoService.updateLevelById(id, level));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            userInfo = userInfoService.findById(id);
            GsonUtils.printResult(response, userInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        if (name.length() > 0) {
            name = URLDecoder.decode(name, "UTF-8");
        }
        try {
            List<UserInfo> userInfoList = userInfoService.findByName(name);
            GsonUtils.printResult(response, userInfoList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByPhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = request.getParameter("phone");
        if (phone.length() > 0) {
            phone = URLDecoder.decode(phone, "UTF-8");
        }
        try {
            userInfo = userInfoService.findByPhone(phone);
            GsonUtils.printResult(response, userInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
