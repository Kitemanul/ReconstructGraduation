package Dao;

import Dao.Celler.CellerMapper;
import Dao.Temperature.TemperatureMapper;
import POJO.CellerInOut;
import POJO.WorkShop;
import Service.TemperatureService.TemperatureService;
import Service.TemperatureService.TemperatureServiceImpl;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class TemperatureDaoTest {

    @Test
    public void test()
    {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        TemperatureMapper temperatureMapper=sqlSession.getMapper(TemperatureMapper.class);
        CellerMapper cellerMapper=sqlSession.getMapper(CellerMapper.class);


        CellerInOut celler=new CellerInOut();
        celler.setGroupid(1);
        celler.setJarid(2);
        celler.setPeriod(1);

        List<CellerInOut> list=cellerMapper.SelectAllCeller(celler);

        HashMap<String,String> map=new HashMap();



        map.put("jarid","罐2");
        map.put("groupid","'1'");
        map.put("intime","'2015-04-18 04:58:28.000'");
        map.put("outtime","'2015-06-27 04:26:38.000'");




        List<WorkShop> s=temperatureMapper.SearchTemperature(map);
        for (WorkShop l:s)
        {
            System.out.println(l.toString());
        }


        return ;



    }

    @Test
    public void errortest()
    {


        TemperatureService service=new TemperatureServiceImpl();

        WorkShop workShop=new WorkShop();
        workShop.setJarid("罐1");
        workShop.setGroupid(Integer.valueOf(2));
        List<WorkShop> list=service.SearchErrorTempearture(workShop);

        for (WorkShop l:list)
        {
            System.out.println(l.toString());
        }

        return;
    }


}
