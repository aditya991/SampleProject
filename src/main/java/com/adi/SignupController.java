package com.adi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignupController
{
    @RequestMapping("/signup")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response)
    {
        String name= request.getParameter("name");
        String email= request.getParameter("email");
        User x= new User(name, email);
        UserServiceImpl y=new UserServiceImpl();
        boolean statusExist =y.findUserExistence(email);
        if(!statusExist)
        {
            y.insertUser(name, email);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("postSignup.jsp");
            mv.addObject("email", email);
            return mv;
        }
        else
        {
            ModelAndView mv1 = new ModelAndView();
            mv1.setViewName("unsuccessfullsignup.jsp");
            mv1.addObject("email", email);
            return mv1;
        }
    }
}

