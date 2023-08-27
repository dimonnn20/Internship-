package com.multithreading;

public class Test5 extends Thread {

    @Override
    public void run() {
        for (int i =0; i<10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable1());
        Thread thread2 = new Test5();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Koniec");
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i =0; i<10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " "+i);
        }
    }
}
