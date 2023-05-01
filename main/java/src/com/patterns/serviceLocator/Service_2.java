package com.patterns.serviceLocator;

public class Service_2 implements Service{
    @Override
    public String getName() {
        return "Service2";
    }

    @Override
    public void execute() {
        System.out.println("Execute Service 2");
    }
}
