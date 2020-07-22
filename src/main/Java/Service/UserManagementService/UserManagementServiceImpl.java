package Service.UserManagementService;

import Dao.BaseDao;
import POJO.User;

import java.sql.Connection;
import java.util.List;

public class UserManagementServiceImpl implements UserManagementService {

    UserDao userDao=null;

    public UserManagementServiceImpl()
    {
        userDao=new UserDaoImpl();
    }


    @Override
    public User SearchaUsersByRightUsername(String username, int permission) {

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

        List<User> res=null;
        Connection con= BaseDao.getConnection();
        res= userDao.SelectUsersByRight(con,right);
        BaseDao.close(con,null,null);
        return res;

    }

    @Override
    public User SearchUser(String username) {

        Connection con=BaseDao.getConnection();
        User user=userDao.getUser(con,username);
        BaseDao.close(con,null,null);
        return user;
    }

    @Override
    public List<User> SearchaAllUser() {
        List<User> res=null;
        Connection con= BaseDao.getConnection();
        //res= userDao.SelectAllUser(con);
        BaseDao.close(con,null,null);
        return res;
    }

    @Override
    public int UpdateUser(User user,String username) {
        Connection con=BaseDao.getConnection();
        int row=0;
        row=userDao.UpdateUser(con,user,username);
        BaseDao.close(con,null,null);
        return row;
    }

    @Override
    public int DeleteUser(String username) {

        Connection con=BaseDao.getConnection();
        int row=0;
        row=userDao.DeleteUserbyUsername(con,username);
        BaseDao.close(con,null,null);
        return row;
    }

    @Override
    public int InsertUser(User user) {

        Connection con=BaseDao.getConnection();
        int row=0;

        row=userDao.InsertUser(con,user);
        BaseDao.close(con,null,null);
        return row;
    }
}
