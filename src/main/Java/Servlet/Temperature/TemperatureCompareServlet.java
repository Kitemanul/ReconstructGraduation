package Servlet.Temperature;

import POJO.CellerInOut;
import POJO.WorkShop;
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

@WebServlet(name = "TemperatureCompareServlet")
public class TemperatureCompareServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");

        String group=request.getParameter("group");
        String jar=request.getParameter("jar");
        String cycle=request.getParameter("cycle");
        String group2=request.getParameter("group2");
        String jar2=request.getParameter("jar2");
        String cycle2=request.getParameter("cycle2");
        String rate1=request.getParameter("rate1");
        String rate2=request.getParameter("rate2");

        TemperatureService service=new TemperatureServiceImpl();


        CellerInOut tem1=new CellerInOut();
        tem1.setGroupid(Integer.valueOf(group));
        tem1.setJarid(Integer.valueOf(jar));
        tem1.setPeriod(Integer.valueOf(cycle));
        List<WorkShop> res1=service.SearchTempearture(Integer.valueOf(rate1),tem1);

        CellerInOut tem2=new CellerInOut();
        tem2.setGroupid(Integer.valueOf(group2));
        tem2.setJarid(Integer.valueOf(jar2));
        tem2.setPeriod(Integer.valueOf(cycle2));
        List<WorkShop> res2=service.SearchTempearture(Integer.valueOf(rate2),tem2);

        JSONArray jsonArray=new JSONArray();
        for(WorkShop temperature:res1)
        {

            JSONObject jsonObject = new JSONObject();
            // 添加键值对
            jsonObject.put("分类", "1组");
            jsonObject.put("温度",temperature.getTemperature(tem1.getJarid()));
            jsonObject.put("变化率",temperature.getRate());
            jsonArray.add(jsonObject);
        }

        for(WorkShop temperature:res2)
        {

            JSONObject jsonObject = new JSONObject();
            // 添加键值对
            jsonObject.put("分类", "2组");
            jsonObject.put("温度",temperature.getTemperature(tem2.getJarid()));
            jsonObject.put("变化率",temperature.getRate());
            jsonArray.add(jsonObject);
        }

        PrintWriter writer = response.getWriter();
        writer.write(jsonArray.toString());
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
