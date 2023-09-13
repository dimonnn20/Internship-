package com.stream;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        int result = list.stream().reduce((accumulator, element) -> accumulator*element).get();
        // System.out.println(result);
        // 5,8,2,4,3
        // accumulator =5, 40, 80, 320, {960} - Optional
        // element =    8, 2,  4,  3,

        List <Integer> list100 = new ArrayList<>();
        Optional <Integer> o = list100.stream().reduce((accumulator, element) -> accumulator*element);
        if (o.isPresent()){
            System.out.println(o.get());
        } else {
            System.out.println("not present");
        }

        int result2 = list.stream().reduce(1,(accumulator, element) -> accumulator*element);
         System.out.println(result2);
        // 5,8,2,4,3
        // accumulator =1, 5, 40, 80, 320, {960} - Optional
        // element =    5, 8,  2,  4, 3
        List <String> strings = new ArrayList<>();
        strings.add("privet");
        strings.add("kak dela?");
        strings.add("OK");
        strings.add("poka");
        String result3 = strings.stream().reduce((a,e)-> a+ " "+e).get();
        System.out.println(result3);

        Map<Integer,Integer> denominations = new HashMap<>();
        denominations.put(100,5);
        denominations.put(200,10);

        int sum = 0;
        for (Map.Entry<Integer, Integer> m:denominations.entrySet()){
            sum += m.getValue()*m.getKey();
        }
        System.out.println("summa w for-each= "+sum);
        Integer i = denominations.entrySet().stream()
                .mapToInt(entry -> (entry.getKey() * entry.getValue()))
                .sum();
        System.out.println("Summa iz Lamdy = "+i);
    }
}
