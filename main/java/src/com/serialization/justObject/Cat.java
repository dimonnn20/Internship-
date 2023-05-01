package com.serialization.justObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cat implements Serializable {
    public String name;
    public int age;
    public int weight;

    public  transient List <String> calls = new ArrayList<>();

    public Cat(String name, int age, int weight, List <String> list) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.calls = list;
    }

    public Cat() {
    }

//    public void save (PrintWriter writer) throws Exception {
//        writer.println(name);
//        writer.println(age);
//        writer.println(weight);
//        writer.flush();
//    }
//
//    public void load (BufferedReader reader) throws Exception {
//        name = reader.readLine();
//        age = Integer.parseInt(reader.readLine());
//        weight = Integer.parseInt(reader.readLine());
//    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", calls=" + calls +
                '}';
    }
}
