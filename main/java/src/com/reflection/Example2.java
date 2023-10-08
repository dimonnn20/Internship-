package com.reflection;

import java.lang.reflect.Field;

public class Example2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Employee employee = new Employee(10,"Dima","IT");

        Class employeeClass = employee.getClass();

        Field field = employeeClass.getDeclaredField("salary");
        field.setAccessible(true);
        double salaryValue = (double)field.get(employee);
        System.out.println(salaryValue);

        field.set(employee,1500);
        System.out.println(employee);

        System.out.println("Привет");
    }



}
