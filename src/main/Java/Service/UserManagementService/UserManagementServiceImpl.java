package Service.UserManagementService;

import Dao.BaseDao;
import Dao.User.UserMapper;
import POJO.User;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.util.List;

public class UserManagementServiceImpl implements UserManagementService {



    @Override
    public User SearchaUsersByRightUsername(String username, int permission) {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        User user=this.SearchUser(username);
        if(user==null)
        {
            return null;
        }
        else {
            if(user.getPermission()==permission)
            {
                return user;
            }
            else
            {
                return null;
            }
        }
    }

    @Override
    public List<User> SearchaUsersByRight(int right) {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        List<User> res=null;
        Connection con= BaseDao.getConnection();
        res= userMapper.SelectUsersByRight(right);

        sqlSession.close();;
        return res;

    }

    @Override
    public User SearchUser(String username) {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        User user=userMapper.getUser(username);
        sqlSession.close();;
        return user;
    }

    @Override
    public List<User> SearchaAllUser() {
        List<User> res=null;
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        res= userMapper.SelectAllUser();
        sqlSession.close();
        return res;
    }

    @Override
    public int UpdateUser(User user,String username) {
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        int row=0;
        row=userMapper.UpdateUser(user,username);

        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public int DeleteUser(String username) {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        int row=0;
        row=userMapper.DeleteUserbyUsername(username);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public int InsertUser(User user) {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        int row=0;

        row=userMapper.InsertUser(user);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }
}
