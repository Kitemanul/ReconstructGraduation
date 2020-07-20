package Servlet.Celler;

import POJO.CellerInOut;
import Service.CellerService.CellerService;
import Service.CellerService.CellerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddCellerServlet")
public class AddCellerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        String time0=request.getParameter("time0");
        String time1=request.getParameter("time1");
        String time2=request.getParameter("time2");
        String time3=request.getParameter("time3");
        String group=request.getParameter("group");
        String jar=request.getParameter("jar");
        String cycle=request.getParameter("cycle");

        CellerInOut celler=new CellerInOut();
        celler.setGroupid(Integer.valueOf(group));
        celler.setJarid(Integer.valueOf(jar));
        celler.setPeriod(Integer.valueOf(cycle));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            celler.setTime(sf.parse(time0));
            celler.setIntime(sf.parse(time1));
            celler.setOuttime(sf.parse(time2));
            celler.setEtime(sf.parse(time3));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        CellerService service=new CellerServiceImpl();
        int row=service.AddCeller(celler);

        PrintWriter writer=response.getWriter();
        if(row==1)
        {
            writer.write("录入成功");
        }
        else
        {
            writer.write("录入失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
