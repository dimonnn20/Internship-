package com.multithreading;

public class Test2 {
    public static void main(String[] args) {
        Thread th1 = new Thread(new MyThread3());
        Thread th2 = new Thread(new MyThread4());
        th1.start();
        th2.start();
    }

}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread4 implements Runnable {
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}
