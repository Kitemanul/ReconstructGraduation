package Dao;

import Dao.Celler.CellerMapper;
import POJO.CellerInOut;
import Util.DateUtils;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        //cellerMapper.AddCeller(celler);
       // int row =cellerMapper.EditCeller(celler,nceller);
        CellerInOut c=new CellerInOut();
        c.setPeriod(-1);
        List<CellerInOut> list=cellerMapper.SelectAllCeller(celler);

        for(CellerInOut celler1:list)
        {
            System.out.println(celler.toString());
        }

        sqlSession.commit();
        sqlSession.close();;




       return;
    }
}
