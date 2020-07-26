package Intercepter;

import Constant.Constant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

         String uri= request.getRequestURI();
         if(uri.contains("Login")||uri.equals("/"))
         {
             return true;
         }
         HttpSession session=request.getSession();

         if(session.getAttribute(Constant.USER_SESSION)!=null)
         {
             return true;
         }

         response.sendRedirect("/");
         return  false;
    }
}
