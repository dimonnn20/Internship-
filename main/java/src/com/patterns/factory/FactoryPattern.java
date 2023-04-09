package com.patterns.factory;

public class FactoryPattern {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Car toyota = factory.create("Toyota");
        toyota.drive();

    }
}

interface Car {
    void drive();
}

class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}

class Factory {
    public Car create(String str) {
        switch (str) {
            case "Toyota":
                return new Toyota();
            case "Audi":
                return new Audi();
        }
        return null;
    }
}

