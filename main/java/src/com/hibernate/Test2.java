package com.hibernate;

import com.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
// Получение объекта из БД
public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Elena", "Petrova", "Sales", 800);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();

           // int myId = employee.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class,1);

            session.getTransaction().commit();
            System.out.println(employee1.toString());
        } finally {
            factory.close();
        }
    }
}
