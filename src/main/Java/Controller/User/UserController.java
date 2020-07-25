package Controller.User;

import Constant.Constant;
import POJO.User;

import Service.LoginService.UserService;
import Service.LoginService.UserServiceImpl;
import Service.RegisterService.RegisterService;
import Util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RegisterService registerService;

    @RequestMapping("/Login")
    @ResponseBody
    public String UserLogin(@RequestParam("user")String username, @RequestParam("pwd") String pw, HttpServletRequest request)
    {
        User user=userService.LoginUser(username);
        if(user!=null)
        {
            if(user.getMm().equals(pw))
            {
                if(user.getPass()==1)
                {
                    if(user.getPermission()==1)
                    {

                        request.getSession().setAttribute(Constant.USER_SESSION,user);
                        return "victory2admin";

                    }
                    else
                    {
                        request.getSession().setAttribute(Constant.USER_SESSION,user);
                        return "victory2user";
                    }
                }
                else
                {
                    return "nopass";
                }
            }
            else
            {
                return "fail";
            }
        }
        else
        {
           return "fail";
        }
    }

    @RequestMapping("/Register")
    @ResponseBody
    public String UserRigister(@RequestParam("user")String username, @RequestParam("pwd") String password)
    {
        User user=userService.LoginUser(username);
        if(user!=null)
        {
            return "fail";
        }
        else
        {
            user=new User();
            user.setPass(0);
            user.setUsername(username);
            user.setMm(MD5Utils.stringToMD5(password));
            user.setPermission(2);
            int row=registerService.Register(user);
            if(row==1)
            {
                return  "victory";
            }
            else
            {
                return "victory";
            }
        }
    }

    @RequestMapping("/Logout")
    public String Logout(HttpServletRequest request)
    {
        request.getSession().removeAttribute(Constant.USER_SESSION);
        return "login.html";
    }



}
