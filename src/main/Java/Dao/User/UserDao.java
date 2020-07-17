package Dao.User;

import POJO.User;

import java.sql.Connection;

public interface UserDao {

    public User getUser(Connection con,String user);
}
