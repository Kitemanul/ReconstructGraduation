package Dao.User;

import POJO.User;
import org.apache.ibatis.annotations.*;

import java.sql.Connection;
import java.util.List;

public interface UserMapper {

    @Select("select * from UserManagement where username=#{username}")
    public User getUser(@Param("username")String username);

    @Insert("insert into UserManagement (username,mm,permission,pass) values(#{username},#{mm},#{permission},#{pass})")
    public int InsertUser(User user);


    @Select("select * from UserManagement")
    public List<User> SelectAllUser();

    @Update("update UserManagement set pass = 1  where username=#{username}")
    public int UpdatePass(@Param("username")String username);

    @Select("select * from UserManagement where permission =#{right}")
    public List<User> SelectUsersByRight(@Param("right")int right);

    @Delete("delete from UserManagement where username=#{username}")
    public int DeleteUserbyUsername(@Param("username") String username);


    public int UpdateUser(@Param("user") User user,@Param("oldusername")String username);
}
