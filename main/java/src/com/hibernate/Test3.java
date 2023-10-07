package com.hibernate;

import com.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
// Получение всех объектов из БД
public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> employeeList = session.createQuery("from Employee where name='Igor'").getResultList();
            for (Employee e:employeeList){
                System.out.println(e.toString());
            }
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
