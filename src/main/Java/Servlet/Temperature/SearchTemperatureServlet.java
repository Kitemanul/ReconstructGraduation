package Servlet.Temperature;

import POJO.Temperature;
import Service.TemperatureService.TemperatureService;
import Service.TemperatureService.TemperatureServiceImpl;
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


        TemperatureService service=new TemperatureServiceImpl();
        Temperature tem=new Temperature();
        tem.setGroupid(Integer.valueOf(group));
        tem.setJarid(Integer.valueOf(jar));
        tem.setCycle(Integer.valueOf(cycle));
        List<Temperature> res=service.SearchTempearture(Integer.valueOf(rate),tem);

        JSONArray jsonArray=new JSONArray();

        PrintWriter writer=response.getWriter();

        for(Temperature t:res)
        {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("时间",t.getTime());
            jsonObject.put("温度",t.getTemp());
            jsonObject.put("罐号",t.getJarid());
            jsonObject.put("组号",t.getGroupid());
            jsonObject.put("周期",t.getCycle());
            jsonObject.put("变化率",t.getRate());
            jsonArray.add(jsonObject);

        }
        writer.write(jsonArray.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
