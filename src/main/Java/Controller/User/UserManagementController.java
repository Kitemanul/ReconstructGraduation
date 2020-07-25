package Controller.User;

import Dao.User.UserMapper;
import POJO.User;
import Service.CellerService.CellerService;
import Service.LoginService.UserService;
import Service.UserManagementService.CheckRegisterService;
import Service.UserManagementService.CheckRegisterServiceImpl;
import Service.UserManagementService.UserManagementService;
import Service.UserManagementService.UserManagementServiceImpl;

import Util.MD5Utils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserManagementController {

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    CheckRegisterService checkRegisterService;

    @Autowired
    UserService userService;

    @RequestMapping("/AddUser")
    @ResponseBody
    public String AddUser(User user)
    {

        User searchUser=userService.LoginUser(user.getUsername());

        if(searchUser!=null)
        {
            return "用户名已被注册";
        }
        else
        {
            user.setPass(1);
            user.setMm(MD5Utils.stringToMD5(user.getMm()));
            int row=userManagementService.InsertUser(user);
            if(row==1)
            {
                return  "添加成功";
            }
            else
            {
                return "添加失败";
            }
        }

    }

    @RequestMapping("/RemoveUser")
    @ResponseBody
    public String DeleteUser(User user)
    {
        int row=userManagementService.DeleteUser(user.getUsername());

        if(row==1)
        {
            return "删除成功";
        }
        else
        {
            return "删除失败";
        }
    }

    @RequestMapping("/EditUser")
    @ResponseBody
    public String EditUser(User newuser,String _username)
    {
        User _user= userService.LoginUser(newuser.getUsername());
        if(_user!=null&&!_user.getUsername().equals(_username))
        {
            return "该用户名已被注册";
        }
        else
        {
            int row=userManagementService.UpdateUser(newuser,_username);

            if(row==1)
            {
                return "修改成功";
            }
            else
            {
                return "修改失败";
            }
        }
    }

    @RequestMapping("/registeringUserdata")
    @ResponseBody
    public String SearchUnregisterUser(User user)
    {
        List<User> list=null;
        list=checkRegisterService.getAllUnRegisterUser(user);
        JSONArray res=new JSONArray();
        for(int i=0;i<list.size();i++)
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("用户名",list.get(i).getUsername());
            jsonObject.put("权限", list.get(i).getPermission());
            jsonObject.put("审核状态", "待审核");
            res.add(jsonObject);
        }
        return res.toString();


    }

    @RequestMapping("/userpass")
    @ResponseBody
    public String CheckUser(String username, HttpServletResponse response)
    {
        response.setCharacterEncoding("utf-8");
        int row=0;
        row=checkRegisterService.Check(username);

        if(row==1)
        {
            return "审核通过";
        }
        else {
            return "审核失败";
        }
    }

    @RequestMapping("/Userdata")
    @ResponseBody
    public String Searchuserdata(User userr)
    {

        List<User> list=userManagementService.SearchaUsers(userr);
        JSONArray jsonArray=new JSONArray();
        if(list.size()!=0)
        {
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
        }
        return jsonArray.toString();
    }





}
