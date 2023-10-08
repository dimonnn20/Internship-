package com.reflection.example2;

import com.patterns.facade.BugTracker;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
    void sum (int a, int b){
        int result = a+b;
        System.out.println("Summa "+a+" i "+b+" = "+ result);
    }
    void subtraction (int a, int b){
        int result = a-b;
        System.out.println("Subtraction "+a+" i "+b+" = "+ result);
    }
    void multiplication (int a, int b){
        int result = a*b;
        System.out.println("Multiplication "+a+" i "+b+" = "+ result);
    }
    void division (int a, int b){
        double result = a/(double)b;
        System.out.println("division "+a+" i "+b+" = "+ result);
    }
}

class TestCalculator {
    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/makad/IdeaProjects/Internship-/main/java/src/com/reflection/example2/test100.txt"))) {
            String methodName = reader.readLine();
            String firstArg = reader.readLine();
            String secondArg = reader.readLine();

            Calculator calculator = new Calculator();
            Class c1 = calculator.getClass();
            Method method = null;
            Method [] methods = c1.getDeclaredMethods();
            for (Method m: methods) {
                if (methodName.equals(m.getName())){
                    method = m;
                }
            }
            method.invoke(calculator, Integer.valueOf(firstArg),Integer.valueOf(secondArg));



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
