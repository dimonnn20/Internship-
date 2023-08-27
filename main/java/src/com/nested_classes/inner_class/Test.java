package com.nested_classes.inner_class;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("blue",4,120);
        System.out.println("-------------------------");
        System.out.println(car);
        Car car2 = new Car("black",4);
        Car.Engine engine = car2.new Engine(150);
        car2.setEngine(engine);
        System.out.println("-------------------------");
        System.out.println(car2);

        Car car3 = new Car("red",3);
        Car.Engine engine2 = car2.new Engine(190);
        car3.setEngine(engine2);
        System.out.println("-------------------------");
        System.out.println(car3);
    }


}
