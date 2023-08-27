package com.patterns.observer.localJAvaObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

    public static void main(String[] args) {

        Cook cook = new Cook("Amigo");
        Cook cook1 = new Cook("Diego");
        Waiter waiter = new Waiter("Yulia");
        waiter.addObserver(cook);
        waiter.addObserver(cook1);
        waiter.order("Soup");
        System.out.println("--------------------------");



    }
}
