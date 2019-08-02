package com.adi;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String path = req.getServletPath();
        long st = System.currentTimeMillis();

        System.out.println("Filter info1 is working...");
        filterChain.doFilter(servletRequest, servletResponse);
        long et = System.currentTimeMillis();

        long tt = (et - st);

        System.out.println("Time take to execute action " + path + "   is  :  " + tt+" milliseconds");
    }

    @Override
    public void destroy() {

    }
}
