package Controller.Celler;

import POJO.CellerInOut;
import Service.CellerService.CellerService;
import Util.DateUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CellerController {

    @Autowired
    CellerService cellerService;


    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping("/AddCeller")
    @ResponseBody
    public String AddCeller(CellerInOut celler)
    {
        int row=cellerService.AddCeller(celler);
        if(row==1)
        {
            return "录入成功";
        }
        else
        {
            return "录入失败";
        }
    }

    @RequestMapping("/EditCeller")
    @ResponseBody
    public String EditCeller(@RequestBody List<CellerInOut> cellers)
    {

        int row=cellerService.EditCeller(cellers.get(0),cellers.get(1));
        if(row==1)
        {
            return "编辑成功";
        }
        else {
            return "编辑失败";
        }

    }


    @RequestMapping("/RemoveCeller")
    @ResponseBody
    public String RemoveCeller(CellerInOut celler)
    {
        int row=cellerService.DeleteCeller(celler);

        if(row==1)
        {
            return "删除成功";
        }
        else
        {
            return "删除失败";
        }
    }


    @RequestMapping("/SearchCellerData")
    @ResponseBody
    public String SearchCellerData(CellerInOut celle)
    {
        List<CellerInOut> res=cellerService.SearchCeller(celle);
        JSONArray jsonArray=new JSONArray();

        if(res.size()==0)
        {

            return "没有搜索到数据";
        }
        else
        {
            for(CellerInOut celler:res)
            {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("时间",DateUtils.Date2String(celler.getTime()));
                jsonObject.put("入窖时间",DateUtils.Date2String(celler.getIntime()));
                jsonObject.put("出窖时间",DateUtils.Date2String(celler.getOuttime()));
                jsonObject.put("周期",celler.getPeriod());
                jsonObject.put("组号",celler.getGroupid());
                jsonObject.put("罐号",celler.getJarid());
                jsonArray.add(jsonObject);

            }

        }
        return  jsonArray.toString();

    }



}
