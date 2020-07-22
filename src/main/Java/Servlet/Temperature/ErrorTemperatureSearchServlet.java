//package Servlet.Temperature;
//
//import POJO.Temperature;
//import Service.TemperatureService.TemperatureService;
//import Service.TemperatureService.TemperatureServiceImpl;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@WebServlet(name = "ErrorTemperatureSearchServlet")
//public class ErrorTemperatureSearchServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//            response.setCharacterEncoding("UTF-8");
//            response.setHeader("content-type", "json/text");
//
//            String group=request.getParameter("group");
//            String jar=request.getParameter("jar");
//
//            TemperatureService service=new TemperatureServiceImpl();
//
//            Temperature tem=new Temperature();
//            tem.setGroupid(Integer.valueOf(group));
//            tem.setJarid(Integer.valueOf(jar));
//            List<Temperature> list=service.SearchErrorTempearture(tem);
//
//            JSONArray jsonArray=new JSONArray();
//            for(Temperature t:list)
//            {
//                JSONObject jsonObject=new JSONObject();
//                jsonObject.put("时间",t.getTime());
//                jsonObject.put("组号",group);
//                jsonObject.put("罐号",jar);
//                jsonObject.put("温度",t.getTemp());
//                jsonArray.add(jsonObject);
//            }
//
//            PrintWriter writer=response.getWriter();
//            writer.write(jsonArray.toString());
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//    }
//}
