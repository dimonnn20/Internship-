package com.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela?");
        list.add("OK");
        list.add("poka");

//        for (String str:list){
//            list.set(list.indexOf(str),String.valueOf(str.length()));
//        }
        //map -берет по очереди каждый элемент стрима, и сопостовляет ему элемент который получается после применения к нему лямбда выражения внутри map
        // 6 9 2 4
        List<Integer> list2 = list.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list2);

        int[] array = {5, 9, 3, 8, 1};
        int [] array2 = Arrays.stream(array).map(el -> {
            if (el % 3 == 0) {
                el = el / 3;
            }
            return el;
        }).toArray();
        System.out.println(Arrays.toString(array2));

        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela?");
        set.add("OK");
        set.add("poka");
        System.out.println(set);

        Set <Integer> set2 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        System.out.println(set2);
        List <Integer> listFromSet = set.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(listFromSet);
    }

}
