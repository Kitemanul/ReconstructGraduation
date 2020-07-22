//package Servlet.UserManagement;
//
//import Service.UserManagementService.UserManagementService;
//import Service.UserManagementService.UserManagementServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(name = "DeleteServlet")
//public class DeleteServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setCharacterEncoding("utf-8");
//        String usernmae=request.getParameter("_username");
//        UserManagementService service=new UserManagementServiceImpl();
//        int row=0;
//        row=service.DeleteUser(usernmae);
//        PrintWriter writer=response.getWriter();
//
//        if(row==1)
//        {
//            writer.write("删除成功");
//        }
//        else
//        {
//            writer.write("删除失败");
//        }
//
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
