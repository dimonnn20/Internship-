package com.example;


import com.patterns.command.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

//        List<Person> people;
//        people = new ArrayList<>();
//        people.add(new Person(1, "ROMAN"));
//        people.add(new Person(2, "ALEXANDER"));
//        people.add(new Person(2, "IVAN"));
//
//        people.add(new Person(3, "ANIA"));
//        System.out.println(people);
//        System.out.println("-----------------------------------");
//        System.out.println(people.stream().filter(person -> person.getId() == 2).findAny());


    }


    public static Map<Integer, Integer> withdrawAmount(int sum) {
        Map<Integer, Integer> denominations = new HashMap<>();
        //          <номинал, количество>
        denominations.put(20, 10);
        denominations.put(50, 10);
        denominations.put(100, 5);
        denominations.put(200, 5);

        int[] array = Arrays.stream(denominations.keySet().toArray()).mapToInt(obj -> (int) obj).toArray();
        Arrays.sort(array);
        int[][] a = new int[array.length + 1][sum + 1];
        a[0][0] = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                a[i + 1][0] = array[i];
                a[0][j] = a[0][j - 1] + 1;
            }
        }

        for (int i = 1; i < array.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                a[i][j] = a[0][j] / a[i][0];
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < a.length; i++) {
            map.put(a[i][0], 0);
        }

        int iMax = a.length - 1;
        int ax;
        while (sum != 0) {
            if (sum < 0) {
                throw new IllegalArgumentException();
            }
            ax = a[iMax][sum];
            int key = a[iMax][0];
            if (denominations.get(key) != 0 && denominations.get(key) <= ax) {
                ax = denominations.get(key);
            }
            map.put(key, (map.get(a[iMax][0]) + ax));
            sum = sum - ax * key;
            iMax = iMax - 1;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
        }
        System.out.println(denominations);
        return map;
    }

    public static Map<Integer, Integer> withdrawAmountDynamic(int sum) {
        List<Integer> banknots = new ArrayList<>();
        banknots.add(100);
        banknots.add(100);
        banknots.add(50);
        banknots.add(50);
        Collections.sort(banknots, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(0));
        for (int i = 1; i < banknots.size(); i++) {
            map.put(i, map.get(i - 1));
            List<Integer> listBuffer = map.get(i - 1);
            listBuffer.set(0, 0);

            for (int j = 1; j < i; j++) {
                Integer buffer = listBuffer.get(i - 1) + banknots.get(j - 1);
                listBuffer.set(j, buffer);
            }
            List<Integer> list2 = map.get(i);
            List<Integer> list3 = new ArrayList<>();
            for (Integer ix : list2) {
                list3.add(ix);
            }
            list3.addAll(listBuffer);
            map.put(i, list3);

            //map.get(i).addAll(listBuffer);
        }
        System.out.println(map);
        return null;


    }

}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
