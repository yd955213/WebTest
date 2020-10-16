package myServlet.login;

import com.google.gson.Gson;
import comm.myGson.ResponseGson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.getWriter().append("pos Method is using");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("passWord");
        System.out.println("获取用户名："+userName + " 和密码:" + pwd);
        ResponseGson responseGson = new ResponseGson();
        if ("yd".equals(userName) && "123".equals(pwd)) {
            responseGson.code = 0;
            responseGson.msg = "用户" +userName+ " 登录成功";
            String responseStr = new Gson().toJson(responseGson, ResponseGson.class);
            System.out.println(responseStr);
            response.getWriter().append(responseStr);
        }else {
            responseGson.code = -1;
            responseGson.msg = "用户" +userName+ " 登录失败";
            String responseStr = new Gson().toJson(responseGson, ResponseGson.class);
            System.out.println(responseStr);
            response.getWriter().append(responseStr);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String userName = request.getParameter("userName");
        String pwd = request.getParameter("passWord");

        response.getWriter().append("获取用户名：" + userName).append(" 和密码" + pwd);
    }
}
