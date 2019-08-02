package com.adi;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class LoginInterceptor implements HandlerInterceptor
{   private static final Logger logger = Logger.getLogger("LoginInterceptor");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(" Pre handle ");

        if(request.getMethod().equals("GET"))
            return true;
        else
            return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info(" Post handle ");
        if(modelAndView.getModelMap().containsKey("status"))
        {
            String status = (String) modelAndView.getModelMap().get("status");
            if(status.equals("SUCCESS!"))
            {
                status = "Authentication " + status;
                modelAndView.getModelMap().put("status",status);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info(" After Completion");
    }
}
