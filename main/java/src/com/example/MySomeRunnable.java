package com.example;

public class MySomeRunnable implements Runnable {

    @Override
    public void run() {
        one();
    }


        public void one () {
            int localOne = 1;
            Shared localTwo = Shared.instance;
            two();
        }
        public void two () {
            Integer localOne = 2;


        }
    }
}

