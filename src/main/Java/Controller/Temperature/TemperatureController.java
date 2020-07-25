package Controller.Temperature;

import POJO.CellerInOut;
import POJO.WorkShop;
import Service.TemperatureService.TemperatureService;
import Service.TemperatureService.TemperatureServiceImpl;
import Util.DateUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.util.List;

@Controller
public class TemperatureController {

    @Autowired
    TemperatureService temperatureService;

    @RequestMapping("/SearchTemperature")
    @ResponseBody
    public String SearchTempeartureData(CellerInOut celler,int rate)
    {
        List<WorkShop> res=temperatureService.SearchTempearture(rate,celler);
        JSONArray jsonArray=new JSONArray();
        if(res.size()!=0)
        {
            for(WorkShop t:res)
            {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("时间", DateUtils.Date2String(t.getTime()));
                jsonObject.put("温度",t.getTemperature(celler.getJarid()));
                jsonObject.put("罐号",celler.getJarid());
                jsonObject.put("组号",celler.getGroupid());
                jsonObject.put("周期",celler.getPeriod());
                jsonObject.put("变化率",t.getRate());
                jsonArray.add(jsonObject);

            }
        }
        return jsonArray.toString();
    }

    @RequestMapping("/TemperatureCompare")
    @ResponseBody
    public String Conparedata(@RequestBody List<CellerInOut> cellers)
    {

        List<WorkShop> res1=temperatureService.SearchTempearture(cellers.get(0).getRate(),cellers.get(0));
        List<WorkShop> res2=temperatureService.SearchTempearture(cellers.get(1).getRate(),cellers.get(1));

        JSONArray jsonArray=new JSONArray();
        for(WorkShop temperature:res1)
        {
            JSONObject jsonObject = new JSONObject();
            // 添加键值对
            jsonObject.put("分类", "1组");
            jsonObject.put("温度",temperature.getTemperature(cellers.get(0).getJarid()));
            jsonObject.put("变化率",temperature.getRate());
            jsonArray.add(jsonObject);
        }

        for(WorkShop temperature:res2) {

            JSONObject jsonObject = new JSONObject();
            // 添加键值对
            jsonObject.put("分类", "2组");
            jsonObject.put("温度", temperature.getTemperature(cellers.get(0).getJarid()));
            jsonObject.put("变化率", temperature.getRate());
            jsonArray.add(jsonObject);
        }

        return jsonArray.toString();
    }

    @RequestMapping("/ErrorTemperatureSearch")
    @ResponseBody
    public String SearchErrorData(CellerInOut celler)
    {
        WorkShop workShop=new WorkShop();
        workShop.setJarid("罐"+celler.getJarid());
        workShop.setGroupid(Integer.valueOf(celler.getGroupid()));
        List<WorkShop> list=temperatureService.SearchErrorTempearture(workShop);

        JSONArray jsonArray=new JSONArray();
        for(WorkShop t:list)
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("时间", DateUtils.Date2String(t.getTime()));
            jsonObject.put("组号",celler.getGroupid());
            jsonObject.put("罐号",celler.getJarid());
            jsonObject.put("温度",t.getTemperature(celler.getJarid()));
            jsonArray.add(jsonObject);
        }

        return jsonArray.toString();
    }

}
