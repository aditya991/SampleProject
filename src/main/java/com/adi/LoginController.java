package com.adi;
import org.hibernate.Query;
//import org.hibernate.metamodel.Metadata;
//import org.hibernate.metamodel.MetadataSources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.*;
import javax.persistence.*;
import org.hibernate.*;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController
{
    @RequestMapping("/login")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response)
    {
        String name= request.getParameter("name");
        String email= request.getParameter("email");
        User x= new User(name, email);

        HttpSession session= request.getSession();
        UUID uuid = UUID.randomUUID();
        String randomUUIDString=uuid.toString();

        UserServiceImpl y=new UserServiceImpl();
        boolean statusExist=y.findUserExistence(email);
//        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
//
//        SessionFactory factory=meta.getSessionFactoryBuilder().build();
//        Session session=factory.openSession();
//
//        //Hibernate Named Query
//        TypedQuery query = session.getNamedQuery("findEmployeeByName");
//        query.setParameter("name","amit");
//
//        List<Employee> employees=query.getResultList();
//
//        Iterator<Employee> itr=employees.iterator();
//        while(itr.hasNext()){
//            Employee e=itr.next();
//            System.out.println(e);


        session.setAttribute("name",name);
        session.setAttribute("email",email);
        session.setAttribute("token",randomUUIDString );
        session.setAttribute( "activation-time", System.currentTimeMillis() );
        //session.setMaxInactiveInterval(60);

        System.out.println("session id is "+session.getId());
        System.out.println("name is "+session.getAttribute("name"));
        System.out.println("email id is "+session.getAttribute("email"));
        System.out.println("token number is "+randomUUIDString);
        if(statusExist==true)
        {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("postLoggedIn.jsp");
            mv.addObject("name", name);
            mv.addObject("email", email);
            return mv;
        }
        else
        {
            ModelAndView mv1= new ModelAndView();
            mv1.setViewName("unsuccessfullLogin.jsp");
            mv1.addObject("email",email);
            return mv1;
        }
    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session)
    {
        System.out.println("Logging you out...session Invalidated");
        ModelAndView mv=new ModelAndView("index.jsp");
        session.invalidate();
        return mv;
    }
    @RequestMapping("/profile")
    public ModelAndView userProfile(HttpSession session /*, HttpServletRequest req, HttpServletResponse res*/)
    {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("profile.jsp");
        mv.addObject("name",session.getAttribute("name"));
        mv.addObject("email",session.getAttribute("email"));
        return mv;
    }
}