package Service.TemperatureService;

import Dao.Celler.CellerMapper;
import Dao.Temperature.TemperatureMapper;
import POJO.CellerInOut;
import POJO.WorkShop;
import Util.DateUtils;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    @Autowired
    TemperatureMapper temperatureMapper;
    @Autowired
    CellerMapper cellerMapper;

    public static float getRate_of_change(List<WorkShop> list,int n,int i,int jar)
    {   float rate=0;
        float Temperature=list.get(i).getTemperature(jar);
        int currow=i;
        if((i-n*2)>0)
        {
            rate=(Temperature-list.get(i-n*2).getTemperature(jar));
            return (float)(Math.round(rate*10000))/10000;
        }
        else
        {
            return 0;
        }

    }

    @Override
    public List<WorkShop> SearchErrorTempearture(WorkShop workShop) {

        HashMap<String,String> map=new HashMap<>();
        map.put("jarid",workShop.getJarid());
        map.put("groupid","'"+String.valueOf(workShop.getGroupid())+"'");
        List<WorkShop> res=temperatureMapper.SearchErrorTemperature(map);

        return res;
    }

    @Override
    public List<WorkShop> SearchTempearture(int rate, CellerInOut in) {

        List<CellerInOut> list=cellerMapper.SelectAllCeller(in);
        if(list.size()==0)
        {
            return new ArrayList<>();
        }
        HashMap<String,String> map=new HashMap();
        map.put("groupid","'"+String.valueOf(in.getGroupid())+"'");
        map.put("jarid","罐"+String.valueOf(in.getJarid()));
        map.put("intime", "'"+DateUtils.Date2String(list.get(0).getIntime())+"'");
        map.put("outtime", "'"+DateUtils.Date2String(list.get(0).getOuttime())+"'");
        List<WorkShop> res=temperatureMapper.SearchTemperature(map);
        for(int i=0;i<res.size();i++)
        {
            res.get(i).setRate(getRate_of_change(res,rate,i,in.getJarid()));
        }
        return res;
    }
}



