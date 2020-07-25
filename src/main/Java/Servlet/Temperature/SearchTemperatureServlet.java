package Servlet.Temperature;

import POJO.CellerInOut;
import POJO.WorkShop;
import Service.TemperatureService.TemperatureService;
import Service.TemperatureService.TemperatureServiceImpl;
import Util.DateUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearTemperatureServlet")
public class SearchTemperatureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "json/text");
        //获取参数

        String group=request.getParameter("group");
        String jar=request.getParameter("jar");
        String cycle=request.getParameter("cycle");
        String rate=request.getParameter("rate");


        WorkShop workShop=new WorkShop();
        CellerInOut celler=new CellerInOut();
        celler.setJarid(Integer.valueOf(jar));
        celler.setGroupid(Integer.valueOf(group));
        celler.setPeriod(Integer.valueOf(cycle));

        TemperatureService service=new TemperatureServiceImpl();
        List<WorkShop> res=service.SearchTempearture(Integer.valueOf(rate),celler);

        JSONArray jsonArray=new JSONArray();

        PrintWriter writer=response.getWriter();


        if(res.size()!=0)
        {
            for(WorkShop t:res)
            {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("时间", DateUtils.Date2String(t.getTime()));
                jsonObject.put("温度",t.getTemperature(celler.getJarid()));
                jsonObject.put("罐号",jar);
                jsonObject.put("组号",group);
                jsonObject.put("周期",cycle);
                jsonObject.put("变化率",t.getRate());
                jsonArray.add(jsonObject);

            }
        }
        writer.write(jsonArray.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
