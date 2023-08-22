package com.patterns.builder;

public class Main {
    public static void main(String[] args) {
        Person person = new PersonBuilderImpl().setName("Mike").setAge(2).build();
        System.out.println(person);
    }
}
