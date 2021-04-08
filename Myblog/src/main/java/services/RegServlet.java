package services;

import dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        int succ = 0;
        String msg = "";

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserInfoDao userInfoDao = new UserInfoDao();
        try{
            succ = userInfoDao.add(username,password);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        PrintWriter writer = response.getWriter();
        writer.println(String.format("{\"succ\":%d,\"msg\":\"%s\"}",succ,msg));
    }
}
