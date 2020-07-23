package Servlet.Temperature;

import POJO.Temperature;
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

@WebServlet(name = "ErrorTemperatureSearchServlet")
public class ErrorTemperatureSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-type", "json/text");

            String group=request.getParameter("group");
            String jar=request.getParameter("jar");

            TemperatureService service=new TemperatureServiceImpl();

            WorkShop workShop=new WorkShop();
            workShop.setJarid("罐"+jar);
            workShop.setGroupid(Integer.valueOf(group));
            List<WorkShop> list=service.SearchErrorTempearture(workShop);

            JSONArray jsonArray=new JSONArray();
            for(WorkShop t:list)
            {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("时间", DateUtils.Date2String(t.getTime()));
                jsonObject.put("组号",group);
                jsonObject.put("罐号",jar);
                jsonObject.put("温度",t.getTemperature(Integer.valueOf(jar)));
                jsonArray.add(jsonObject);
            }

            PrintWriter writer=response.getWriter();
            writer.write(jsonArray.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
