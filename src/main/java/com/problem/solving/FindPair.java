package com.problem.solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FindPair {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {

        Arrays.sort(arr);
        int pairCount = 0;

        for(int index = 0; index < arr.length; index++) {
            for (int secondIndex = index + 1; secondIndex < arr.length; secondIndex++) {
                if((arr[secondIndex] - arr[index]) == k) {
                    pairCount += 1;
                    break;
                } else if((arr[secondIndex] - arr[index]) > k) {
                    break;
                }
            }
        }

        return  pairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

