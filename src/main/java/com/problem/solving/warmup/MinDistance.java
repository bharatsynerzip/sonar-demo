package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinDistance {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        int len = a.length;
        int minDistance = len, indexDiff;
        Integer lastIndex;

        for (int index = 0; index < len && minDistance != 1; index++) {

            lastIndex = lastIndexMap.get(a[index]);

            if(lastIndex == null) {
                lastIndexMap.put(a[index], index);
            } else {
                indexDiff = index - lastIndex;
                minDistance = minDistance > indexDiff ? indexDiff : minDistance;
            }
        }

        if (minDistance == len) {
            return -1;
        } else {
            return minDistance;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
