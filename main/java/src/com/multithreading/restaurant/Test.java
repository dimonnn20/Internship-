package com.multithreading.restaurant;

public class Test {

    public static void main(String[] args) {

        Cook cook = new Cook("Amigo");
        Cook cook1 = new Cook("Diego");
        Waiter waiter = new Waiter("Yulia");
        Dishes[] dishes = Dishes.values();
        for (int i =0; i < 10;i++){
            waiter.order(dishes[(int)(Math.random()*8)].name());
        }
        System.out.println("--------------------------");
        cook.start();
        cook1.start();


    }
}
