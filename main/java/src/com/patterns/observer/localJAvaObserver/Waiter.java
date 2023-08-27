package com.patterns.observer.localJAvaObserver;

import java.util.Observable;
import java.util.Observer;

public class Waiter extends Observable {
private String name;

    public Waiter(String name) {
        this.name = name;
    }

    public void order (String order) {
        System.out.println(order+" is received by waiter "+name);
        setChanged();
        notifyObservers(order);
    }

    @Override
    public String toString() {
        return name;
    }
}
