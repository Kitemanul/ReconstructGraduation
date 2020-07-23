package Servlet.Celler;

import POJO.CellerInOut;
import Service.CellerService.CellerService;
import Service.CellerService.CellerServiceImpl;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CellerSearchServlet")
public class CellerSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        //获取参数
        String time1=request.getParameter("time1");
        String time2=request.getParameter("time2");
        String group=request.getParameter("group");
        String jar=request.getParameter("jar");
        String cycle=request.getParameter("cycle");

        CellerInOut celle=new CellerInOut();

        if(!time1.isEmpty())
        {
            celle.setIntime(DateUtils.String2Date(time1));
        }
        if(!time2.isEmpty())
        {
            celle.setOuttime(DateUtils.String2Date(time2));
        }
        if(!group.isEmpty())
        {
            celle.setGroupid(Integer.valueOf(group));
        }
        if(!jar.isEmpty())
        {
            celle.setJarid(Integer.valueOf(jar));
        }
        if(!cycle.isEmpty())
        {
            celle.setPeriod(Integer.valueOf(cycle));
        }

        CellerService service=new CellerServiceImpl();

        List<CellerInOut> res=service.SearchCeller(celle);
        JSONArray jsonArray=new JSONArray();

        if(res.size()==0)
        {
            PrintWriter writer=response.getWriter();
            writer.write("没有搜索到数据");
        }
        else
        {
            for(CellerInOut celler:res)
            {
                JSONObject jsonObject=new JSONObject();
                if(celler.getTime()!=null)
                {
                    jsonObject.put("时间",DateUtils.Date2String(celler.getTime()));
                }
                else
                {
                    jsonObject.put("时间","");
                }
                if(celler.getIntime()!=null)
                {
                    jsonObject.put("入窖时间",DateUtils.Date2String(celler.getIntime()));
                }
                else
                {
                    jsonObject.put("入窖时间","");
                }
                if(celler.getOuttime()!=null)
                {
                    jsonObject.put("出窖时间",DateUtils.Date2String(celler.getOuttime()));
                }
                else
                {
                    jsonObject.put("出窖时间","");
                }
                jsonObject.put("周期",celler.getPeriod());
                jsonObject.put("组号",celler.getGroupid());
                jsonObject.put("罐号",celler.getJarid());
                jsonArray.add(jsonObject);

            }
            PrintWriter writer=response.getWriter();
            writer.write(jsonArray.toString());
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
