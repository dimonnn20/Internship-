package com.serialization.justObject;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat("Barsyk",3,6);
        PrintWriter printWriter = new PrintWriter(new FileWriter("C:/my/serSave.txt"));
        cat.save(printWriter);
        System.out.println(cat);

        Cat cat1 = new Cat();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/my/ser.txt"));
        cat1.load(bufferedReader);
        System.out.println(cat1);
    }
}
