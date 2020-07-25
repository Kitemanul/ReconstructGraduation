package service;

import Dao.User.UserMapper;
import POJO.User;
import Service.LoginService.UserService;
import Service.LoginService.UserServiceImpl;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)// SpringJUnit支持，由此引入Spring-Test框架支持！
@ContextConfiguration({"classpath:ApplicationContext.xml"})//用于加载bean
public class login {

    @Autowired
    UserService userService;
    @Test
    public void LoginUser() {

        User user=userService.LoginUser("admin");

        System.out.println(user.toString());

    }
}
