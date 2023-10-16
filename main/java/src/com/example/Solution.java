package com.example;

public class Solution {
    public static void main(String[] args) {
        int a = 1024;
        //System.out.println(Integer.toBinaryString(a));
        String s = String.format("%8s",Integer.toBinaryString(a)).replace(" ","0");
        System.out.println(s);
    }
}


