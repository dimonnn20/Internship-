package com.patterns.abstractFactory;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Factory<Factory> factory = new AbstractFactory();
        Factory<Tank> tankFactory = factory.create("Tank");
        Factory<Car> carFactory = factory.create("Car");

        Car toyota = carFactory.create("Toyota");
        Car audi = carFactory.create("Audi");

        Tank abrams = tankFactory.create("Abrams");
        Tank leopard = tankFactory.create("Leopard");

        toyota.drive();
        audi.drive();
        abrams.shoot();
        leopard.shoot();

    }

}

interface Factory<T> {
    T create(String type);
}

class AbstractFactory implements Factory {
    @Override
    public Object create(String type) {
        switch (type) {
            case "Tank":
                return new TankFactory();
            case "Car":
                return new CarFactory();
            default:
                return null;
        }
    }
}

interface Tank {
    void shoot();
}

interface Car {
    void drive();
}

class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}

class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

class Abrams implements Tank {
    @Override
    public void shoot() {
        System.out.println("Abrams is shooting");
    }
}

class Leopard implements Tank {
    @Override
    public void shoot() {
        System.out.println("Leopard is shooting");
    }
}

class TankFactory implements Factory {
    @Override
    public Object create(String type) {
        switch (type) {
            case "Abrams":
                return new Abrams();
            case "Leopard":
                return new Leopard();
            default:
                return null;
        }
    }
}

class CarFactory implements Factory {
    @Override
    public Object create(String type) {
        switch (type) {
            case "Audi":
                return new Toyota();
            case "Toyota":
                return new Audi();
            default:
                return null;
        }
    }
}



