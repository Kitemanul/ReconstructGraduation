package Servlet.UserManagement;

import POJO.User;
import Service.UserManagementService.UserManagementService;
import Service.UserManagementService.UserManagementServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchUserData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        UserManagementService userManagementService=new UserManagementServiceImpl();

        String username=req.getParameter("username");
        String permission=req.getParameter("right");
        List<User> list=null;
        User user=null;
        PrintWriter writer=resp.getWriter();

        if(username.isEmpty()&&permission.equals("0"))
        {
            list=userManagementService.SearchaAllUser();
        }
        else if(permission.equals("0"))
        {
            user=userManagementService.SearchUser(username);
        }
        else if(username.isEmpty())
        {
            list=userManagementService.SearchaUsersByRight(Integer.valueOf(permission));
        }
        else
        {
            user=userManagementService.SearchaUsersByRightUsername(username,Integer.valueOf(permission));
        }

        if(list!=null)
        {
            JSONArray jsonArray=new JSONArray();
            for(User u:list)
            {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("用户名",u.getUsername());
                jsonObject.put("权限",u.getPermission());
                if(u.getPass()==1)
                {
                    jsonObject.put("审核状态", "通过");
                }
                else {
                    jsonObject.put("审核状态", "待审核");
                }
                jsonArray.add(jsonObject);
            }
            writer.write(jsonArray.toString());
        }
        if(user!=null)
        {
            JSONArray jsonArray=new JSONArray();

            JSONObject jsonObject=new JSONObject();
            jsonObject.put("用户名",user.getUsername());
            jsonObject.put("权限",user.getPermission());
            if(user.getPass()==1)
            {
                jsonObject.put("审核状态", "通过");
            }
            else {
                jsonObject.put("审核状态", "待审核");
            }
            jsonArray.add(jsonObject);

            writer.write(jsonArray.toString());

        }
    }
}
