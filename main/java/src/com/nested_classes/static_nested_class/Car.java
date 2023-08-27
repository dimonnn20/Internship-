package com.nested_classes.static_nested_class;

public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount, Engine engine ) {
        System.out.println("Создание Car {String color, int doorCount,int horsePower}");
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    public Car(String color, int doorCount) {
        System.out.println("Создание Car {String color, int doorCount}");
        this.color = color;
        this.doorCount = doorCount;
    }

    @Override
    public String toString() {
        return "My Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public static class Engine {
        private int horsePower;

        public Engine(int horsePower) {
            System.out.println("Создание Engine");
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

