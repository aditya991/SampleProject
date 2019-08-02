package com.adi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class SessionValidate implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        //typecasting needed to access the getSession()method;
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpSession sess=request.getSession(false);
        if(sess!= null)
        {
            String id= (String) sess.getAttribute("token");
            System.out.print("Inside session validate :");
            System.out.println(id);
            filterChain.doFilter(servletRequest,servletResponse);
//            List<User> list = getSessionFactory().getCurrentSession().createQuery(" from ClientAppts client order by client.lName ").list();
        }
        else
        {
            //RequestDispatcher rd=servletRequest.getRequestDispatcher("index.jsp");
            servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
            //rd.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {}
}
