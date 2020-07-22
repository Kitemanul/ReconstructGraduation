package Dao;

import Dao.User.UserMapper;
import POJO.User;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import org.apache.log4j.Logger;

public class UserDaoTest {

    static Logger logger=Logger.getLogger(UserDaoTest.class);
    @Test
    public void test()
    {
        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        UserMapper userDao=sqlSession.getMapper(UserMapper.class);

        User user=new User();
        user.setUsername("122");
        user.setMm("fdfd");
        user.setPermission(2);
        user.setPass(2);

        //User usr=userDao.getUser(user);
        //int row=userDao.InsertUser(user);
        // int row=userDao.DeleteUserbyUsername("1221");
        //List<User> list=userDao.SelectUsersByRight(1);
        int row=userDao.UpdateUser(user,"1221");

        sqlSession.commit();
        sqlSession.close();

        return ;



    }
}
