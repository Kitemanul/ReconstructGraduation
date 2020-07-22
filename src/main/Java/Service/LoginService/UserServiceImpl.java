package Service.LoginService;


import Dao.User.UserMapper;
import POJO.User;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;

public class UserServiceImpl implements UserService {


    @Override
    public User LoginUser(String username) {

        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        User user=null;
        try
        {
            user=userMapper.getUser(username);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }

        return user;
    }



}
