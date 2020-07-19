package Dao.User;

import POJO.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {

    public User getUser(Connection con,String user);

    public int InsertUser(Connection con,User user);

    public List<User> SelectAllUser(Connection con);


}
