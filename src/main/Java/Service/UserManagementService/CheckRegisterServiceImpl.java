package Service.UserManagementService;

import Dao.BaseDao;
import Dao.User.UserDao;
import Dao.User.UserDaoImpl;
import POJO.User;

import java.sql.Connection;
import java.util.ArrayList;
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
            if(user.getPass()==0)
            {
                return user;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(con,null,null);
        }
        return null;

    }

    @Override
    public List<User> getAllUnRegisterUser() {
        List<User> res=new ArrayList<>();
        Connection con=null;

        try {
            con= BaseDao.getConnection();
            List<User> temp=userDao.SelectAllUser(con);

            for(User user:temp)
            {
                if(user.getPass()==0)
                {
                    res.add(user);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(con,null,null);
        }

        return res;
    }

    @Override
    public int Check(String username) {
        int res=0;
        Connection con=BaseDao.getConnection();
        UserDao userDao=new UserDaoImpl();
        res=userDao.UpdatePass(con,username);
        BaseDao.close(con,null,null);

        return res;
    }
}
