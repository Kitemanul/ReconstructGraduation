package Service.LoginService;

import Dao.BaseDao;
import Dao.User.UserDao;
import Dao.User.UserDaoImpl;
import POJO.User;
import org.junit.Test;

import java.sql.Connection;

public class UserServiceImpl implements UserService {

    private UserDao userdao=null;
    public UserServiceImpl()
    {
        userdao=new UserDaoImpl();
    }
    @Override
    public User LoginUser(String username) {
        Connection con=null;
        User user=null;
        try
        {
            con= BaseDao.getConnection();
            user=userdao.getUser(con,username);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(con,null,null);
        }

        return user;
    }

    @Test
    public void loginUser() {
        UserServiceImpl service=new UserServiceImpl();
        User user=service.LoginUser("admin");

        System.out.println(user.getMm());

    }



}
