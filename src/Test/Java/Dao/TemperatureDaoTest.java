//package Dao;
//
//import Dao.Celler.CellerDao;
//import Dao.Celler.CellerDaoImpl;
//import POJO.CellerInOut;
//import POJO.User;
//import org.junit.Test;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TemperatureDaoTest {
//
//    @Test
//    public void test()
//    {
//        Connection con=BaseDao.getConnection();
//
//        PreparedStatement preparedStatement=null;
//
//
//        String[] condition=new String[]{"组号","罐号","周期"};
//
//        Object[] object= new Object[]{1,2,1};
//
//        CellerDao cellerDao=new CellerDaoImpl();
//        List<CellerInOut> s=cellerDao.SelectAllCeller(con,condition,object);
//
//
//        return ;
//
//
//
//    }
//}
