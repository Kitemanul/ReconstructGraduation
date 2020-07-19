package Dao;

import POJO.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoTest {


    @Test
    public void test()
    {
        Connection con=BaseDao.getConnection();

        PreparedStatement preparedStatement=null;
        String sql="select * from UserManagement where pass=0 and permission=2";
        List<User> res=new ArrayList<>();
        ResultSet rs=null;

        try {
            rs=BaseDao.Find(con,sql,preparedStatement,rs,new Object[]{});

            while(rs.next())
            {
                User user=new User();
                user.setUsername(rs.getString("username").trim());
                user.setPermission(rs.getInt("permission"));
                res.add(user);
            }

            BaseDao.close(null,preparedStatement,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ;



    }
}
