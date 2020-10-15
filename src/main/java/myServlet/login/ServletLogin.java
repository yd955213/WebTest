package myServlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.getWriter().append("pos Method is using");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/x-www-form-urlencoded,charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("passWord");
        System.out.println(userName + "  " + pwd);
        response.getWriter().append("获取用户名：" + userName).append(" 和密码" + pwd);
        if ("yd".equals(userName) && "123".equals(pwd)) {
            response.getWriter().append("  登陆成功");
        }else {
            response.getWriter().append("  登陆失败");
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
