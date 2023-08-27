package com.multithreading;

public class Test3 {
    public static void main(String[] args) {
        new Thread (()-> System.out.println(Thread.currentThread().getName())).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();


    }
}
