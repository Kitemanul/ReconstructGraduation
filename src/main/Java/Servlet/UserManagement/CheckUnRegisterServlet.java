package Servlet.UserManagement;

import Service.UserManagementService.CheckRegisterService;
import Service.UserManagementService.CheckRegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CheckUnRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        CheckRegisterService service=new CheckRegisterServiceImpl();
        String username=request.getParameter("username");
        int row=0;
        row=service.Check(username);
        PrintWriter writer=response.getWriter();
        if(row==1)
        {
            writer.write("审核通过");
        }
        else {
            writer.write("审核失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
