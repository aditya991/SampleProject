package com.adi;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDAO
{
    HibernateTemplate template;

    public UserDAO(){}
//    public void xyz()
//    {
//        Query query = template.createSQLQuery(
//                "select s.stock_code from stock s where s.stock_code = :stockCode")
//                .setParameter("stockCode", "7277");
//        List result = query.list();
//    }
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    //method to save employee
    public void saveuser(User e){
        template.save(e);
    }
    //method to update employee
    public void updateuser(User e){
        template.update(e);
    }
    //method to delete employee
    public void deleteuser(User e)
    {
        template.delete(e);
    }
    //method to return one employee of given email
    public User getById(int id)
    {
        User e=(User) template.get(User.class, id);
        return e;
    }
    //method to return all employees
    public List<User> getuser()
    {
        List<User> list=new ArrayList<User>();
        return template.loadAll(User.class);
    }
//    public Token getByIdTok(int id)
//    {
//        Token t=(Token) template.get(Token.class, id);
//        return t;
//    }
//    public void addTok(Token t)
//    {
//        template.save(Token.class.getName(),t);
//    }
}