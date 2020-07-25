package Dao;

import Dao.Celler.CellerMapper;
import POJO.CellerInOut;
import Service.CellerService.CellerService;
import Util.DateUtils;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)// SpringJUnit支持，由此引入Spring-Test框架支持！
@ContextConfiguration({"classpath:ApplicationContext.xml"})//用于加载bean
public class CellerDaoTest {

    @Autowired
    CellerService cellerService;
    @Test
    public void test()
    {
       CellerInOut celler=new CellerInOut();

       celler.setPeriod(-1);
       celler.setJarid(0);
       celler.setGroupid(0);


       List<CellerInOut> list=cellerService.SearchCeller(celler);





       return;
    }
}
