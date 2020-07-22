//package Servlet.UserManagement;
//
//import POJO.User;
//import Service.UserManagementService.UserManagementService;
//import Service.UserManagementService.UserManagementServiceImpl;
//import Util.MD5Utils;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(name = "EditUserServlet")
//public class EditUserServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setCharacterEncoding("UTF-8");
//        UserManagementService service=new UserManagementServiceImpl();
//        PrintWriter out=response.getWriter();
//        //原始姓名
//        String _username=request.getParameter("_username");
//
//        //新数据
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
//        String right=request.getParameter("right");
//
//        User newuser=null;
//        newuser=service.SearchUser(username);
//        if(!_username.equals(username)&&newuser!=null)
//        {
//            out.write("该用户名已被注册");
//        }
//        else
//        {
//            User user=null;
//            user=service.SearchUser(_username);
//            user.setPermission(Integer.valueOf(right));
//            user.setMm(MD5Utils.stringToMD5(password));
//            user.setUsername(username);
//
//            int row=service.UpdateUser(user,_username);
//
//            if(row==1)
//            {
//                out.write("修改成功");
//            }
//            else
//            {
//                out.write("修改失败");
//            }
//        }
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
