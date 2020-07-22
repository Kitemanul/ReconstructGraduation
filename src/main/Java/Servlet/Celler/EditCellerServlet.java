//package Servlet.Celler;
//
//import POJO.CellerInOut;
//import Service.CellerService.CellerService;
//import Service.CellerService.CellerServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//@WebServlet(name = "EditCellerServlet")
//public class EditCellerServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("content-type", "json/text");
//        //获取参数
//        String _time0=request.getParameter("_time0");
//        String _time1=request.getParameter("_time1");
//        String _time2=request.getParameter("_time2");
//        String _group=request.getParameter("_group");
//        String _jar=request.getParameter("_jar");
//        String _cycle=request.getParameter("_cycle");
//
//
//        CellerInOut oudceller=new CellerInOut();
//        oudceller.setGroupid(Integer.valueOf(_group));
//        oudceller.setJarid(Integer.valueOf(_jar));
//        oudceller.setPeriod(Integer.valueOf(_cycle));
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        try {
//            oudceller.setTime(sf.parse(_time0));
//            oudceller.setIntime(sf.parse(_time1));
//            oudceller.setOuttime(sf.parse(_time2));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        String time0=request.getParameter("time0");
//        String time1=request.getParameter("time1");
//        String time2=request.getParameter("time2");
//        String group=request.getParameter("group");
//        String jar=request.getParameter("jar");
//        String cycle=request.getParameter("cycle");
//
//        CellerInOut newceller=new CellerInOut();
//        newceller.setGroupid(Integer.valueOf(group));
//        newceller.setJarid(Integer.valueOf(jar));
//        newceller.setPeriod(Integer.valueOf(cycle));
//        try {
//            newceller.setTime(sf.parse(time0));
//            newceller.setIntime(sf.parse(time1));
//            newceller.setOuttime(sf.parse(time2));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        PrintWriter writer=response.getWriter();
//        CellerService service=new CellerServiceImpl();
//        int row=service.EditCeller(oudceller,newceller);
//        if(row==1)
//        {
//            writer.write("编辑成功");
//        }
//        else {
//            writer.write("编辑失败");
//        }
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
