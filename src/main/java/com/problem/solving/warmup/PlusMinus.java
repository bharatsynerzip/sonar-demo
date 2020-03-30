package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int positiveCount = 0, negativeCount = 0, zeroCount = 0;

        for(int value : arr) {
            if(value > 0) {
                positiveCount += 1;
            } else if (value < 0) {
                negativeCount += 1;
            } else {
                zeroCount += 1;
            }
        }

        long len = arr.length;

        System.out.println((double) positiveCount/len);
        System.out.println((double) negativeCount/len);
        System.out.println((double) zeroCount/len);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
