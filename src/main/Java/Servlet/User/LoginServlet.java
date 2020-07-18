package Servlet.User;

import Constant.Constant;
import POJO.User;
import Service.LoginService.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;


public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("user");
        String pw=request.getParameter("pwd");

        UserServiceImpl service=new UserServiceImpl();
        PrintWriter out=response.getWriter();
        User user=service.LoginUser(username);
        if(user!=null)
        {
            if(user.getMm().equals(pw))
            {
                if(user.getPass()==1)
                {
                    if(user.getPermission()==1)
                    {
                        request.getSession().setAttribute(Constant.USER_SESSION,user);
                        out.write("victory2admin");
                    }
                    else
                    {
                        request.getSession().setAttribute(Constant.USER_SESSION,user);
                        out.write("victory2user");
                    }
                }
                else
                {
                    out.write("nopass");
                }
            }
            else
            {
                out.write("fail");
            }
        }
        else
        {
            out.write("fail");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
