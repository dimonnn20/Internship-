package com.patterns.serviceLocator;

public class Service_1 implements Service{
    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Execute Service 1");
    }
}
