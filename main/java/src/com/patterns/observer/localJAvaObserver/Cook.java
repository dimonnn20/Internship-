package com.patterns.observer.localJAvaObserver;


import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook implements Observer {

    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object order) {
            System.out.println(name+": started cooking "+order+" from the waiter "+o.toString());
    }
}
