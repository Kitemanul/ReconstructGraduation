//package Servlet.Celler;
//
//import POJO.CellerInOut;
//import Service.CellerService.CellerService;
//import Service.CellerService.CellerServiceImpl;
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
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@WebServlet(name = "CellerSearchServlet")
//public class CellerSearchServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setCharacterEncoding("utf-8");
//        //获取参数
//        String time1=request.getParameter("time1");
//        String time2=request.getParameter("time2");
//        String group=request.getParameter("group");
//        String jar=request.getParameter("jar");
//        String cycle=request.getParameter("cycle");
//
//        ArrayList<String> list=new ArrayList<>();
//        ArrayList<Object> l=new ArrayList<>();
//        if(!time1.isEmpty())
//        {
//            list.add("入窖时间");
//            l.add(time1);
//        }
//        if(!time2.isEmpty())
//        {
//            list.add("出窖时间");
//            l.add(time2);
//        }
//        if(!group.isEmpty())
//        {
//            list.add("组号");
//            l.add(group);
//        }
//        if(!jar.isEmpty())
//        {
//            list.add("罐号");
//            l.add(jar);
//        }
//        if(!cycle.isEmpty())
//        {
//            list.add("周期");
//            l.add(cycle);
//        }
//        String[] str=new String[list.size()];
//        Object[] objects=new Object[list.size()];
//        for(int i=0;i<list.size();i++)
//        {
//            str[i]=list.get(i);
//            objects[i]=l.get(i);
//        }
//
//        CellerService service=new CellerServiceImpl();
//
//        List<CellerInOut> res=service.SearchCeller(str,objects);
//        JSONArray jsonArray=new JSONArray();
//        for(CellerInOut celler:res)
//        {
//            JSONObject jsonObject=new JSONObject();
//            if(celler.getTime()!=null)
//            {
//                jsonObject.put("时间",celler.getTime().toString());
//            }
//            else
//            {
//                jsonObject.put("时间","");
//            }
//            if(celler.getIntime()!=null)
//            {
//                jsonObject.put("入窖时间",celler.getIntime().toString());
//            }
//            else
//            {
//                jsonObject.put("入窖时间","");
//            }
//            if(celler.getOuttime()!=null)
//            {
//                jsonObject.put("出窖时间",celler.getOuttime().toString());
//            }
//            else
//            {
//                jsonObject.put("出窖时间","");
//            }
//            jsonObject.put("周期",celler.getPeriod());
//            jsonObject.put("组号",celler.getGroupid());
//            jsonObject.put("罐号",celler.getJarid());
//            jsonArray.add(jsonObject);
//
//        }
//        PrintWriter writer=response.getWriter();
//        writer.write(jsonArray.toString());
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
