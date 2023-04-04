package com.patterns.nullObject;

import java.io.File;

public class Solution {
    public static void main(String[] args) {
        Animal animal = getAnimal();
        animal.eat();
    }

    static Animal getAnimal() {
        try {
            if (new File("noSuchFile.txt").exists()) {
                return new Lion();
            }
        } finally {
            return new NoAnimal();
        }
    }
}

interface Animal {
    void eat();
}

class Lion implements Animal {
    @Override
    public void eat() {
        System.out.println("Lion eat");
    }
}
class NoAnimal implements Animal {
    @Override
    public void eat() {
        System.out.println("Animal is not exist");
    }
}