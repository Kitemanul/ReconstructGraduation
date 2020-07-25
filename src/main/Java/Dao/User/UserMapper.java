package Dao.User;

import POJO.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.util.List;

public interface UserMapper {

    public List<User> getUsers(User user);

    @Select("select * from UserManagement where username=#{username}")
    public User getUserbyName(@Param("username") String username);

    @Insert("insert into UserManagement (username,mm,permission,pass) values(#{username},#{mm},#{permission},#{pass})")
    public int InsertUser(User user);

    @Update("update UserManagement set pass = 1  where username=#{username}")
    public int UpdatePass(@Param("username")String username);


    @Delete("delete from UserManagement where username=#{username}")
    public int DeleteUserbyUsername(@Param("username") String username);


    public int UpdateUser(@Param("user") User user,@Param("oldusername")String username);
}
