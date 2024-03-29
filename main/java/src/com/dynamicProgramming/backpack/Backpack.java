package com.dynamicProgramming.backpack;

import java.util.ArrayList;

public class Backpack {
    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int count = weights.length;
        int maxWeight = 13;

        int[][] A;
        A = new int[count + 1][maxWeight+1];

        for (int k = 0; k <= count; k++) {
            for (int s = 0; s <= maxWeight; s++) {
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    if (s >= weights[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - weights[k - 1]] + prices[k - 1]);
                    } else {
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }
        //====================================================
        for (int i = 0; i<=count; i++){
            for (int j =0; j <= maxWeight; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        //======================================================


        ArrayList<Integer> result = new ArrayList<>();
        traceResult(A,weights,count,maxWeight,result);
        for (Integer i: result){
            System.out.println(i);
        }
    }

    private static void traceResult (int [][] A, int [] weight, int k, int s, ArrayList<Integer> result){
        if (A[k][s] == 0){
            return;
        }
        if (A[k-1][s] == A [k][s]){
            traceResult(A,weight,k-1,s,result);
        }else {
            traceResult(A,weight,k-1,s-weight[k-1],result);
            result.add(0,k);
        }
    }
}
