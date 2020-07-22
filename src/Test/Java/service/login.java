package service;

import Dao.User.UserMapper;
import POJO.User;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class login {

    @Test
    public void LoginUser() {
        String username="admin";
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = null;
        try {
            user = userMapper.getUser(username);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return ;
    }
}
