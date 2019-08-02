package com.adi;

import org.springframework.data.annotation.Id;
import org.springframework.orm.hibernate3.HibernateTemplate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
//@Table(name = "user")
//@NamedQueries(
//{
//    @NamedQuery
//    (
//        name = "findEmployeeByName",
//        query = "select u from user u where u.name= :name"
//    )
//})

public class User
{
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public User(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public User() {
    }
//    public class userDAO
//    {
//
//        HibernateTemplate template;
//        public void setTemplate(HibernateTemplate template)
//        {
//            this.template = template;
//        }
//
//        //method to save User
//        public void saveuser(User e)
//        {
//            template.save(e);
//        }
//        //method to update User
//        public void updateuser(User e)
//        {
//            template.update(e);
//        }
//        //method to delete User
//        public void deleteuser(User e)
//        {
//            template.delete(e);
//        }
//        //method to return one User of given id
//        public User getById(int id)
//        {
//            User e=(User)template.get(User.class,id);
//            return e;
//        }
//        //method to return all users
//        public List<User> getusers()
//        {
//            List<User> list=new ArrayList<User>();
//            list=template.loadAll(User.class);
//            return list;
//        }
}
