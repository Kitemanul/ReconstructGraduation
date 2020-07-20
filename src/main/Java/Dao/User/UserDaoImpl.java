package Dao.User;

import Dao.BaseDao;
import POJO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                    user.setUsername(set.getString("username").trim());
                    user.setMm(set.getString("mm").trim());
                    user.setPermission(set.getInt("permission"));
                    user.setPass(set.getInt("pass"));
                    user.setPrimary_key(set.getInt("primary_key"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                BaseDao.close(null,preparedStatement,set);
            }
        }

        return user;
    }

    @Override
    public List<User> SelectUsersByRight(Connection con, int right) {
        List<User> res=new ArrayList<>();
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        String sql="select * from UserManagement where permission =?";

        try {
            rs=BaseDao.Find(con,sql,preparedStatement,rs,new Object[]{right});
            while(rs.next())
            {
                User user=new User();
                user.setUsername(rs.getString("username").trim());
                user.setPermission(rs.getInt("permission"));
                user.setMm(rs.getString("mm"));
                user.setPass(rs.getInt("pass"));
                res.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(null,preparedStatement,rs);
        }

        return  res;
    }

    @Override
    public int UpdatePass(Connection con, String username) {
        int res=0;
        PreparedStatement preparedStatement=null;
        String sql="update UserManagement set pass = 1  where username=?";
        try {
           res=BaseDao.Update(con,sql,preparedStatement,new Object[]{username});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(null,preparedStatement,null);
        }


        return res;
    }


    @Override
    public List<User> SelectAllUser(Connection con) {

        PreparedStatement preparedStatement=null;
        String sql="select * from UserManagement";
        List<User> res=new ArrayList<>();
        ResultSet rs=null;

        try {
            rs=BaseDao.Find(con,sql,preparedStatement,rs,new Object[]{});

            while(rs.next())
            {
                User user=new User();
                user.setUsername(rs.getString("username").trim());
                user.setPermission(rs.getInt("permission"));
                user.setMm(rs.getString("mm"));
                user.setPass(rs.getInt("pass"));
                res.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(null,preparedStatement,rs);
        }
        return res;
    }

    @Override
    public int UpdateUser(Connection con, User user,String username) {

        PreparedStatement preparedStatement=null;
        int row=0;
        String sql="update UserManagement set username = ?,mm=?,permission=? where username=?";

        try {
            row=BaseDao.Update(con,sql,preparedStatement,new Object[]{user.getUsername(),user.getMm(),user.getPermission(),username});
        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {
            BaseDao.close(null,preparedStatement,null);
        }
        return row;
    }

    @Override
    public int DeleteUserbyUsername(Connection con, String username) {

        PreparedStatement pre=null;
        int row=0;
        String sql="delete from UserManagement where username=?";

        try {
            row=BaseDao.Delete(con,sql,pre,new Object[]{username});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(null,pre,null);
        }
        return row;
    }

    @Override
    public int InsertUser(Connection con, User user) {

        PreparedStatement preparedStatement=null;
        int row=0;
        String sql="insert into UserManagement (username,mm,permission,pass) values(?,?,?,?)";

        Object ob[]={user.getUsername(),user.getMm(),user.getPermission(),user.getPass()};


        try {
            row=BaseDao.Update(con,sql,preparedStatement,ob);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(null,preparedStatement,null);
        }
        return row;
    }
}
