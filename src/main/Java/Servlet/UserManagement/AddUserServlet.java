//package Servlet.UserManagement;
//
//import POJO.User;
//import Service.UserManagementService.UserManagementService;
//import Service.UserManagementService.UserManagementServiceImpl;
//import Util.MD5Utils;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class AddUserServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        UserManagementService service=new UserManagementServiceImpl();
//        resp.setCharacterEncoding("utf-8");
//        String username=req.getParameter("username");
//        String password=req.getParameter("password");
//        String right=req.getParameter("right");
//        User user=null;
//        PrintWriter out=resp.getWriter();
//        user=service.SearchUser(username);
//
//
//        if(user!=null)
//        {
//            out.write("用户名已被注册");
//        }
//        else
//        {
//            user=new User();
//            user.setPass(1);
//            user.setUsername(username);
//            user.setMm(MD5Utils.stringToMD5(password));
//            user.setPermission(Integer.valueOf(right));
//            int row=service.InsertUser(user);
//            if(row==1)
//            {
//                out.write("添加成功");
//            }
//            else
//            {
//                out.write("添加失败");
//            }
//        }
//
//    }
//}
