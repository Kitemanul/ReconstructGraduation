package Dao.User;

import Dao.BaseDao;
import POJO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(Connection con, String username) {

        PreparedStatement preparedStatement=null;
        User user=null;
        ResultSet set=null;

        String sql="select * from dbo.UserManagement where username=?";

        if(con!=null)
        {
            try {
                set=BaseDao.Find(con,sql,preparedStatement,set,new Object[]{username});
                if(set.next())
                {
                    user=new User();
                    user.setUsername(set.getString("username"));
                    user.setMm(set.getString("mm"));
                    user.setPermission(set.getInt("permission"));
                    user.setPass(set.getInt("pass"));
                    user.setPrimary_key(set.getInt("primary_key"));
                }

                BaseDao.close(null,preparedStatement,set);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
