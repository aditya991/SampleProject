package com.adi;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.util.ArrayList;
import java.util.*;

public class UserServiceImpl implements UserService
{

    public UserServiceImpl(){}

    Resource r=new ClassPathResource("applicationContext.xml");

    ApplicationContext factory= new ClassPathXmlApplicationContext("applicationContext.xml");
//    BeanFactory factory=new XmlBeanFactory(r);

    UserDAO dao=(UserDAO)factory.getBean("d");

    @Override
    public User findUser( String email)
    {
        List<User> ls=new ArrayList<User>();
        ls=dao.getuser();
        User u= new User();
        Iterator<User> it= ls.iterator();
        while(it.hasNext())
        {
            if(email.equals(it.next().getEmail()))
            {
                return it.next();
            }
        }
        User dummy=new User("","");
        return dummy;
    }

    @Override
    public boolean findUserExistence(String email)
    {
        List<User> ls=new ArrayList<User>();
        ls=dao.getuser();
        User u= new User();
        Iterator<User> it= ls.iterator();
        while(it.hasNext())
        {
            if(email.equals(it.next().getEmail()))
            {
                return true;
            }
        }
        return false;
    }


//    @Override
//    public void deleteTok(String email) {
//
//    }
//
//    @Override
//    public void validateTok(String email, int tok)
//    {
//        List<User> ls=new ArrayList<User>();
//        ls=dao.getuser();
//        User u= new User();
//        Iterator<User> it= ls.iterator();
//        while(it.hasNext())
//        {
//            if(tok.equals(it.next().getEmail()))
//            {
//
//            }
//        }
//    }

    @Override
    public void insertUser(String name, String email)
    {

        User e=new User(name, email);
        dao.saveuser(e);
    }

    @Override
    public void RemoveUser(User u) {
        dao.deleteuser(u);
    }
}
