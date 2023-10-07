package com.example;

import java.util.List;

public class Subscriber implements Observer{
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Dear " +name+ "\nWe have some changes in vacancies"+vacancies+"\n=====================\n");
    }

    @Override
    public void vacancyAdded(List<String> vacancies) {
        System.out.println("Dear " +name+ "\n vacancyAdded"+vacancies+"\n=====================\n");
    }

    @Override
    public void vacancyRemoved(List<String> vacancies) {
        System.out.println("Dear " +name+ "\n vacancyRemoved"+vacancies+"\n=====================\n");
    }
}
