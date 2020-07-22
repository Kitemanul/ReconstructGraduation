//package Dao.Temperature;
//
//import Dao.BaseDao;
//import POJO.Temperature;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TemperatureDaoImpl implements TemperatureDao {
//    @Override
//    public List<Temperature> SearchTemperature(Connection con, Object[] objects,String jar) {
//
//        PreparedStatement pre=null;
//        String sql="select 时间,罐"+jar+" from 温度数据  where 组号 = ? AND(罐"+jar+" between 1 and 50) AND(时间 between ? AND ?) order by 时间";
//        List<Temperature> res=new ArrayList<>();
//        ResultSet rs=null;
//        try {
//            rs=BaseDao.Find(con,sql,pre,rs,objects);
//
//            while(rs.next())
//            {
//                Temperature temp=new Temperature();
//                temp.setTime(rs.getObject(1).toString());
//                temp.setTemp(rs.getFloat(2));
//                res.add(temp);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            BaseDao.close(null,pre,rs);
//        }
//        return res;
//    }
//
//    @Override
//    public List<Temperature> SearchErrorTemperature(Connection con, Object[] objects, String jar) {
//
//        PreparedStatement pre=null;
//        String sql="select 组号,时间,罐"+jar+" from dbo.温度数据1  where 组号 = ? order by 时间";
//        ResultSet set=null;
//        List<Temperature> res=new ArrayList<>();
//
//        try {
//            set=BaseDao.Find(con,sql,pre,set,objects);
//            while(set.next())
//            {
//                Temperature tem=new Temperature();
//                tem.setTemp(set.getFloat(3));
//                tem.setTime(set.getObject(2).toString());
//                tem.setGroupid(set.getInt(1));
//                res.add(tem);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            BaseDao.close(null,pre,null);
//        }
//        return res;
//    }
//}
