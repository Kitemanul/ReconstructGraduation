package Dao;

import Dao.Celler.CellerDao;
import Dao.Celler.CellerDaoImpl;
import Dao.Temperature.TemperatureMapper;
import POJO.CellerInOut;
import POJO.User;
import POJO.WorkShop;
import Util.DateUtils;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TemperatureDaoTest {

    @Test
    public void test()
    {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        TemperatureMapper temperatureMapper=sqlSession.getMapper(TemperatureMapper.class);
        WorkShop workshop=new WorkShop();
        workshop.setGroupid(1);
        workshop.setJarid("'罐2'");
        CellerInOut celler=new CellerInOut();
        celler.setIntime(DateUtils.String2Date("2010-11-24 11:52:45.000"));
        celler.setOuttime(DateUtils.String2Date("2020-11-24 11:52:45.000"));

        HashMap<String,String> map=new HashMap();
        map.put("jarid","'罐2'");
        map.put("intime","'2010-11-24 11:52:45.000'");
        map.put("outtime","");
        map.put("groupid","'2'");

        List<WorkShop> s=temperatureMapper.SearchTemperature(map);


        return ;



    }
}
