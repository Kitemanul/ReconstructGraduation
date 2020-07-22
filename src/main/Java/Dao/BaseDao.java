//package Dao;
//
//import java.io.InputStream;
//import java.sql.*;
//import java.util.Properties;
//
//public class BaseDao {
//
//    private String driver;
//    private String username;
//    private String password;
//    private String url;
//
//
//    public BaseDao()
//    {
//        Properties properties = new Properties();
//
//        //通过类加载器读取资源
//        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("DB.properties");
//        try {
//            properties.load(in);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        driver = properties.getProperty("driver");
//        username = properties.getProperty("username");
//        password = properties.getProperty("password");
//        url = properties.getProperty("url");
//    }
//
//
//
//
//
//    public  Connection getConnection()
//    {
//        Connection connection=null;
//
//        try{
//            Class.forName(driver);
//            connection= DriverManager.getConnection(url,username,password);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return  connection;
//    }
//
//    public ResultSet Find(Connection con,String sql,PreparedStatement pre,ResultSet set,Object[] param) throws SQLException
//    {
//            pre=con.prepareStatement(sql);
//            for(int i=0;i<param.length;i++)
//            {
//                pre.setObject(i+1,param[i]);
//            }
//            set=pre.executeQuery();
//
//            return  set;
//
//    }
//
//    public int Update(Connection con,String sql,PreparedStatement pre,Object[] param) throws SQLException
//    {
//        pre=con.prepareStatement(sql);
//        for(int i=0;i<param.length;i++)
//        {
//            pre.setObject(i+1,param[i]);
//        }
//        int row=pre.executeUpdate();
//
//        return  row;
//
//    }
//
//
//    public void close(Connection con, PreparedStatement p, ResultSet rs)
//    {
//        try {
//            if(rs!=null)
//            {
//                rs.close();
//            }
//            if(p!=null)
//            {
//                p.close();
//            }
//            if(con!=null)
//            {
//                con.close();
//            }
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//    }
//
//
//
//}
