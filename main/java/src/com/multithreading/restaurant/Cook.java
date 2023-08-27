package com.multithreading.restaurant;


import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Thread {
    public void setOrders(LinkedBlockingQueue<String> orders) {
        this.orders = orders;
    }

    private String name;
    private LinkedBlockingQueue<String> orders;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String order;
        while (!OrderManager.orders.isEmpty()) {
            try {
                order = OrderManager.orders.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(name + ": starts cooking the order for " + order);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + ": finished cooking " + order);

        }
    }
}
