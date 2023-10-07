package com.example;

public class Storage {

    private static class InstanceHolder {
        private static final Storage ourInstance = new Storage();

        private static void print () {
            System.out.println("*****************************");
            System.out.println("Work class: InstanceHolder ()");
            System.out.println("*****************************");
        }
    }

    public static Storage getInstance() {
        System.out.println("*****************************");
        System.out.println("Work method: getInstance ()");
        System.out.println("*****************************");
        return InstanceHolder.ourInstance;
    }
}
