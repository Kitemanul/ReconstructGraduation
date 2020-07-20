package Dao.User;

import POJO.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {

    public User getUser(Connection con,String user);

    public int InsertUser(Connection con,User user);

    public List<User> SelectAllUser(Connection con);

    public int UpdatePass(Connection con,String username);

    public List<User> SelectUsersByRight(Connection con,int right);

    public int DeleteUserbyUsername(Connection con,String username);

    public int UpdateUser(Connection con,User user,String username);




}
