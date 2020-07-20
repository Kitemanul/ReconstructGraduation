package Servlet.UserManagementServlet;

import POJO.User;
import Service.UserManagementService.CheckRegisterService;
import Service.UserManagementService.CheckRegisterServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



public class SearchUnregisterUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");

        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "json/text");

        CheckRegisterService service=new CheckRegisterServiceImpl();
        List<User> list=null;
        PrintWriter out=resp.getWriter();
        if(username.isEmpty())
        {
            list=service.getAllUnRegisterUser();

            JSONArray res=new JSONArray();
            for(int i=0;i<list.size();i++)
            {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("用户名",list.get(i).getUsername());
                jsonObject.put("权限", list.get(i).getPermission());
                jsonObject.put("审核状态", "待审核");
                res.add(jsonObject);
            }

            out.write(res.toString());

        }
        else
        {
            User user=service.getUnRegisterUser(username);
            JSONObject jsonObject=new JSONObject();
            if(user!=null)
            {
                jsonObject.put("用户名",user.getUsername());
                jsonObject.put("权限", user.getPermission());
                jsonObject.put("审核状态", "待审核");
                JSONArray res=new JSONArray();
                res.add(jsonObject);
                out.write(res.toString());
            }


        }

    }
}
