package Service.RegisterService;

import Dao.BaseDao;
import Dao.User.UserDao;
import Dao.User.UserDaoImpl;
import POJO.User;

import java.sql.Connection;

public class RegisterServeceImpl implements RegisterService {

    private UserDao userdao=null;

    public RegisterServeceImpl()
    {
        userdao=new UserDaoImpl();
    }

    @Override
    public int Register(User user) {
        Connection con=null;
        int row=0;
        try{
            con= BaseDao.getConnection();
            row=userdao.InsertUser(con,user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return row;

    }

    @Override
    public User getUser(String username) {
        Connection con=null;
        User user=null;
        try{
            con= BaseDao.getConnection();
            user=userdao.getUser(con,username);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;

    }


}
