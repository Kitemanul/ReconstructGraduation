package Service.RegisterService;

import Dao.BaseDao;
import Dao.User.UserMapper;
import POJO.User;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;

public class RegisterServeceImpl implements RegisterService {



    @Override
    public int Register(User user) {

        SqlSession sqlSession= MyBatisUtil.openSqlsession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        int row=0;
        try{

            row=userMapper.InsertUser(user);
            sqlSession.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

            sqlSession.close();
        }
        return row;

    }

    @Override
    public User getUser(String username) {
        SqlSession sqlSession= MyBatisUtil.openSqlsession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        User user=null;
        try{
            user=userMapper.getUser(username);
            sqlSession.commit();;
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
