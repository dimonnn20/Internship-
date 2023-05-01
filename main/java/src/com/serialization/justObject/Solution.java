package com.serialization.justObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        List <String> list = new ArrayList<>();
        list.add("Czernuy");
        list.add("Zyrnyy");
        list.add("Obrzora");

        Cat cat = new Cat("Gena", 8, 12,list);

        FileOutputStream fileOutput = new FileOutputStream("C:/my/cat.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(cat);
        fileOutput.close();
        outputStream.close();

        FileInputStream fileInput = new FileInputStream("C:/my/cat.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInput);
        Cat newCat = (Cat) inputStream.readObject();
        fileInput.close();
        inputStream.close();
        System.out.println(newCat);



//        Cat cat = new Cat("Barsyk",3,6);
//        Dog dog = new Dog("Sharyk", 7);
//        Human human = new Human(cat,dog);
//        PrintWriter printWriter = new PrintWriter(new FileWriter("C:/my/serSave.txt"));
//        human.save(printWriter);
//        System.out.println("Human save:"+ human);
//
//        Human human1 = new Human();
//        BufferedReader reader = new BufferedReader(new FileReader("C:/my/ser.txt"));
//        human1.load(reader);
//        System.out.println("Human load: "+human1);

//        Cat cat1 = new Cat();
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/my/ser.txt"));
//        cat1.load(bufferedReader);
//        System.out.println(cat1);
    }
}
