package Service.UserManagementService;

import Dao.BaseDao;
import Dao.User.UserDao;
import Dao.User.UserDaoImpl;
import POJO.User;

import java.sql.Connection;
import java.util.List;

public class CheckRegisterServiceImpl implements CheckRegisterService
{
    UserDao userDao=null;

    public CheckRegisterServiceImpl()
    {
        userDao=new UserDaoImpl();
    }

    @Override
    public User getUnRegisterUser(String username) {
        Connection con=null;
        User user=null;
        try{
            con=BaseDao.getConnection();
            user=userDao.getUser(con,username);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public List<User> getAllUnRegisterUser() {
        List<User> res=null;
        Connection con=null;

        try {
            con= BaseDao.getConnection();
            res=userDao.SelectAllUser(con);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public boolean Check(User user) {



        return false;
    }
}
