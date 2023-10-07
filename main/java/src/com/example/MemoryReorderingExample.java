package com.example;

public class MemoryReorderingExample {
    public static void main(String[] args) {
        MemoryReorderingExample memoryReorderingExample = new MemoryReorderingExample();
        memoryReorderingExample.T1();
        memoryReorderingExample.T2();
    }

    private int x;
    private int y;

    public void T1() {
        x = 1;
        int r1 = y;
    }

    public void T2() {
        y = 1;
        int r2 = x;
    }
}
