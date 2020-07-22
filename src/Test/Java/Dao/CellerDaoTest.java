//package Dao;
//
//import POJO.CellerInOut;
//import POJO.User;
//import Service.CellerService.CellerService;
//import Service.CellerService.CellerServiceImpl;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.junit.Test;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class CellerDaoTest {
//
//    @Test
//    public void test()
//    {
//        Connection con=BaseDao.getConnection();
//        PreparedStatement pre=null;
//        String sql="select * from 出窖入窖";
//        ResultSet set=null;
//        try {
//            set=BaseDao.Find(con,sql,pre,set,new Object[]{});
//
//            List<CellerInOut> res=new ArrayList<>();
//
//
//                while(set.next())
//                {
//                    CellerInOut celler=new CellerInOut();
//                    celler.setTime(set.getTimestamp("时间"));
//                    celler.setPeriod(set.getInt("周期"));
//                    celler.setIntime(set.getTimestamp("入窖时间"));
//                    celler.setOuttime(set.getTimestamp("出窖时间"));
//                    celler.setJarid(set.getInt("罐号"));
//                    celler.setGroupid(set.getInt("组号"));
//                    res.add(celler);
//                }
//
//            JSONArray jsonArray=new JSONArray();
//            for(CellerInOut celler:res)
//            {
//                JSONObject jsonObject=new JSONObject();
//                if(celler.getTime()!=null)
//                {
//                    jsonObject.put("时间",celler.getTime().toString());
//                }
//                else
//                {
//                    jsonObject.put("时间","");
//                }
//                if(celler.getIntime()!=null)
//                {
//                    jsonObject.put("入窖时间",celler.getIntime().toString());
//                }
//                else
//                {
//                    jsonObject.put("入窖时间","");
//                }
//                if(celler.getOuttime()!=null)
//                {
//                    jsonObject.put("出窖时间",celler.getOuttime().toString());
//                }
//                else
//                {
//                    jsonObject.put("出窖时间","");
//                }
//                jsonObject.put("周期",celler.getPeriod());
//                jsonObject.put("组号",celler.getGroupid());
//                jsonObject.put("罐号",celler.getJarid());
//                jsonArray.add(jsonObject);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return;
//    }
//}
