package com.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class employeeClass = Class.forName("com.reflection.Employee");

//        Class employeeClass2 = Employee.class;
//
//        Employee employee = new Employee();
//        Class employeeClass3 = employee.getClass();

        Field someField = employeeClass.getField("id");
        System.out.println("Type of id field = "+someField.getType());
        System.out.println("***********************");
        Field [] fields = employeeClass.getFields();
        // Получаем все поля класса, кроме приватных
        for (Field f:fields){
            System.out.println("Type of field "+f.getName()+" = "+ f.getType());
        }
        System.out.println("*************************");

        Field [] allFields = employeeClass.getDeclaredFields();

        // Получаем все поля класса, в том числе и приватные
        for (Field f:allFields){
            System.out.println("Type of field "+f.getName()+" = "+ f.getType());
        }
        System.out.println("Конец работы с полями");
        System.out.println("---------------------------------");

        // Начинаем работать с методами

        Method method = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method increaseSalary = "+method.getReturnType()+" , parameters type = "+ Arrays.toString(method.getParameterTypes()));
        System.out.println("*********************");

        Method method2 = employeeClass.getMethod("setSalary",double.class);
        System.out.println("Return type of method increaseSalary = "+method2.getReturnType()+" , parameters type = "+ Arrays.toString(method2.getParameterTypes()));

        System.out.println("***************************************");

        Method [] methods = employeeClass.getMethods();
        for (Method m:methods){
            System.out.println("Name of method = "+m.getName()+", return type = "+m.getReturnType()+", method parameters = "+Arrays.toString(m.getParameterTypes()));
        }

        System.out.println("***************************************");

        Method [] allMethods = employeeClass.getDeclaredMethods();
        for (Method m:allMethods){
            System.out.println("Name of method = "+m.getName()+", return type = "+m.getReturnType()+", method parameters = "+Arrays.toString(m.getParameterTypes()));
        }

        System.out.println("***************************************");

        Method [] allMethods2 = employeeClass.getDeclaredMethods();
        for (Method m:allMethods){
            if (Modifier.isPublic(m.getModifiers())){
                System.out.println("Name of method = "+m.getName()+", return type = "+m.getReturnType()+", method parameters = "+Arrays.toString(m.getParameterTypes()));
            }
        }
            System.out.println("------------------------------------------");

            // Работа с конструкторами
        Constructor constructor1 = employeeClass.getConstructor();
        System.out.println("Constructor has "+constructor1.getParameterCount()+" parameters, their types are: "+Arrays.toString(constructor1.getParameterTypes()));
        System.out.println("*********************************************");

        Constructor constructor2 = employeeClass.getConstructor(int.class,String.class,String.class);
        System.out.println("Constructor has "+constructor2.getParameterCount()+" parameters, their types are: "+Arrays.toString(constructor2.getParameterTypes()));
        System.out.println("*********************************************");

        Constructor [] constructors = employeeClass.getConstructors();
        for (Constructor c:constructors){
            System.out.println("Constructor has "+c.getParameterCount()+" parameters, their types are: "+Arrays.toString(c.getParameterTypes()));
        }

        System.out.println("------------------------------------------");

        // Создание объекта класса employee c помощью рефлексии

        //Устаревший метод
        Employee emp = (Employee) employeeClass.newInstance();
        System.out.println(emp);
        System.out.println("*********************************************");

        // Новый метод
        Constructor <Employee> cons = employeeClass.getConstructor();
        Employee obj1 = cons.newInstance();
        System.out.println(obj1);
        System.out.println("*********************************************");

        Constructor <Employee>const2 = employeeClass.getConstructor(int.class,String.class,String.class);
        Employee obj2 = const2.newInstance(5,"Zaur","IT");
        System.out.println(obj2);
        Method method1 = employeeClass.getMethod("setSalary", double.class);
        method1.invoke(obj2,1500);
        System.out.println(obj2);
        System.out.println("*********************************************");


    }
}
