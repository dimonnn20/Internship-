package com.multithreading.restaurant;

import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager {
    public static final LinkedBlockingQueue<String> orders = new LinkedBlockingQueue<>();


}
