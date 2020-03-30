package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulTriplets {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {

        if(arr == null || arr.length < 1) {
            return 0;
        }

        int i = 0, j = 1, k = 2, beautifulTripletsCount = 0;
        int firstDiff, secondDiff;
        int len = arr.length;

        while(i < len && j < len && k < len) {

            firstDiff = arr[j] - arr[i];
            secondDiff = arr[k] - arr[j];

            if(firstDiff == d && secondDiff == d) {

                beautifulTripletsCount += 1;
                i += 1;

                continue;
            }

            if(firstDiff > d) {
                i += 1;
            } else if(firstDiff < d || firstDiff == 0 || secondDiff > d) {
                j += 1;
            }

            if(secondDiff < d || secondDiff == 0) {
                k += 1;
            }
        }

        return  beautifulTripletsCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

