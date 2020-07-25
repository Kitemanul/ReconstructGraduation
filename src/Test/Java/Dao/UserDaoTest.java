package Dao;

import Dao.User.UserMapper;
import POJO.User;
import Service.LoginService.UserService;
import Service.UserManagementService.UserManagementService;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)// SpringJUnit支持，由此引入Spring-Test框架支持！
@ContextConfiguration({"classpath:ApplicationContext.xml"})//用于加载bean
public class UserDaoTest {

    @Autowired
    UserManagementService userManagementService;
    @Test
    public void test()
    {


        User user=new User();
        user.setUsername("");

;

        List<User> list=userManagementService.SearchaUsers(user);

        return ;



    }
}
