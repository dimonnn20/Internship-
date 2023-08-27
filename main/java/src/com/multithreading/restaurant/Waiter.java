package com.multithreading.restaurant;

public class Waiter{
private String name;

    public Waiter(String name) {
        this.name = name;
    }

    public void order (String order) {
        System.out.println("Order for "+ order +" got by waiter");
        OrderManager.orders.offer(order);
    }

    public String getName() {
        return name;
    }
//    public static class OrderManager {
//        public static final LinkedBlockingQueue<String> orders = new LinkedBlockingQueue<>();
//
//
//    }
}
