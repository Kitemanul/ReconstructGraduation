package Servlet.User;

import POJO.User;
import Service.RegisterService.RegisterServeceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("user");
        String password=request.getParameter("pwd");

        RegisterServeceImpl servece=new RegisterServeceImpl();
        PrintWriter pr=response.getWriter();
        User user=servece.getUser(username);

        if(user!=null)
        {
            pr.write("fail");
        }
        else
        {
            user=new User();
            user.setPass(0);
            user.setUsername(username);
            user.setMm(password);
            user.setPermission(2);
            int row=servece.Register(user);
            if(row==1)
            {
                pr.write("victory");
            }
            else
            {
                pr.write("victory");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
