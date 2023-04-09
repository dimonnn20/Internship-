package com.generics;

public class Main {
    public static void main(String[] args) {
        Item<String> stringItem = new Item<>();
        stringItem.setT("Hello world");

        Item<Integer> integerItem = new Item<>();
        integerItem.setT(15);

        String str = stringItem.getT();
        Integer in = integerItem.getT();


    }
}

class Item<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
