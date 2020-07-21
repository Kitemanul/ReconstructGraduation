package Service.TemperatureService;

import Dao.BaseDao;
import Dao.Celler.CellerDao;
import Dao.Celler.CellerDaoImpl;
import Dao.Temperature.TemperatureDao;
import Dao.Temperature.TemperatureDaoImpl;
import POJO.CellerInOut;
import POJO.Temperature;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TemperatureServiceImpl implements TemperatureService {

    TemperatureDao temperatureDao=null;
    public TemperatureServiceImpl()
    {
        temperatureDao=new TemperatureDaoImpl();
    }

    public static float getRate_of_change(List<Temperature> list,int n,int i) throws SQLException
    {   float rate=0;
        float Temperature=list.get(i).getTemp();
        int currow=i;
        if((i-n*2)>0)
        {
            rate=(Temperature-list.get(i-n*2).getTemp());
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
    public List<Temperature> SearchTempearture(int rate, Temperature tem) {

        Connection con= BaseDao.getConnection();

        String[] condition=new String[]{"组号","罐号","周期"};

        Object[] object= new Object[]{tem.getGroupid(),tem.getJarid(),tem.getCycle()};

        CellerDao cellerDao=new CellerDaoImpl();
        List<CellerInOut> s=cellerDao.SelectAllCeller(con,condition,object);


        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Object[] objects=new Object[]{tem.getGroupid(),s.get(0).getIntime().toString(),s.get(0).getOuttime().toString()};
        List<Temperature> res=temperatureDao.SearchTemperature(con,objects,String.valueOf(tem.getJarid()));

        try {
        for(int i=0;i<res.size();i++)
        {
            res.get(i).setJarid(tem.getJarid());
            res.get(i).setGroupid(tem.getGroupid());
            res.get(i).setCycle(tem.getCycle());
            res.get(i).setRate(getRate_of_change(res,rate,i));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(con,null,null);
        }


        return res;
    }
}



