package Service.TemperatureService;

import Dao.BaseDao;
import Dao.Celler.CellerDao;
import Dao.Celler.CellerDaoImpl;
import Dao.Celler.CellerMapper;
import Dao.Temperature.TemperatureDao;
import Dao.Temperature.TemperatureDaoImpl;
import Dao.Temperature.TemperatureMapper;
import POJO.CellerInOut;
import POJO.Temperature;
import POJO.WorkShop;
import Util.DateUtils;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TemperatureServiceImpl implements TemperatureService {

    TemperatureDao temperatureDao=null;
    public TemperatureServiceImpl()
    {
        temperatureDao=new TemperatureDaoImpl();
    }

    public static float getRate_of_change(List<WorkShop> list,int n,int i) throws SQLException
    {   float rate=0;
        float Temperature=list.get(i).getTeperatrue();
        int currow=i;
        if((i-n*2)>0)
        {
            rate=(Temperature-list.get(i-n*2).getTeperatrue());
            return (float)(Math.round(rate*10000))/10000;
        }
        else
        {
            return 0;
        }

    }

    @Override
    public List<Temperature> SearchErrorTempearture(Temperature tem) {

        Connection con=BaseDao.getConnection();

        Object[] object= new Object[]{tem.getGroupid()};

        List<Temperature> res=temperatureDao.SearchErrorTemperature(con,object,String.valueOf(tem.getJarid()));
        BaseDao.close(con,null,null);
        return res;
    }

    @Override
    public List<WorkShop> SearchTempearture(int rate, CellerInOut in) {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        TemperatureMapper temperatureMapper=sqlSession.getMapper(TemperatureMapper.class);
        CellerMapper cellerMapper=sqlSession.getMapper(CellerMapper.class);


        List<CellerInOut> list=cellerMapper.SelectAllCeller(in);

        if(list.size()==0)
        {
            return new ArrayList<>();
        }

        HashMap<String,String> map=new HashMap();
        map.put("groupid",String.valueOf(in.getGroupid()));
        map.put("jarid","罐"+String.valueOf(in.getJarid()));
        map.put("intime", "'"+DateUtils.Date2String(list.get(0).getIntime())+"'");
        map.put("outtime", "'"+DateUtils.Date2String(list.get(0).getOuttime())+"'");

        List<WorkShop> res=temperatureMapper.SearchTemperature(map);

        try {
        for(int i=0;i<res.size();i++)
        {
            res.get(i).setRate(getRate_of_change(res,rate,i));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            sqlSession.close();
        }


        return res;
    }
}



