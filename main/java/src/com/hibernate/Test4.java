package com.hibernate;

import com.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {

    //Изменение объекта в БД
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

           // Employee emp = session.get(Employee.cl ass,2);
           // emp.setSalary(1500);
            session.createQuery("update Employee set salary=2000 where name ='Dima'").executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
