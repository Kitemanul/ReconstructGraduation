package Dao;

import Dao.Celler.CellerDao;
import Dao.Celler.CellerMapper;
import POJO.CellerInOut;
import POJO.User;
import Service.CellerService.CellerService;
import Service.CellerService.CellerServiceImpl;
import Util.DateUtils;
import Util.MyBatisUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CellerDaoTest {

    @Test
    public void test()
    {
       CellerInOut celler=new CellerInOut();
       celler.setTime(DateUtils.String2Date("2014-11-17 08:45:36.000"));
       celler.setIntime(DateUtils.String2Date("2014-11-17 08:45:36.000"));
       celler.setOuttime(DateUtils.String2Date("2014-11-17 08:45:36.000"));
       celler.setPeriod(1);
       celler.setJarid(2);
       celler.setGroupid(100);
       celler.setEtime(DateUtils.String2Date("2014-11-17 08:45:36.000"));

        CellerInOut nceller=new CellerInOut();
        nceller.setTime(DateUtils.String2Date("2014-11-18 08:45:36.000"));
        nceller.setIntime(DateUtils.String2Date("2014-11-17 08:45:36.000"));
        nceller.setOuttime(DateUtils.String2Date("2014-11-17 08:45:36.000"));
        nceller.setPeriod(1);
        nceller.setJarid(2);
        nceller.setGroupid(100);
        nceller.setEtime(DateUtils.String2Date("2014-11-17 08:45:36.000"));

        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        CellerMapper cellerMapper=sqlSession.getMapper(CellerMapper.class);
        cellerMapper.AddCeller(celler);
        int row =cellerMapper.EditCeller(celler,nceller);

        sqlSession.commit();
        sqlSession.close();;




       return;
    }
}
