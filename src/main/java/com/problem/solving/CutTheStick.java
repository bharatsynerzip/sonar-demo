package com.problem.solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CutTheStick {

    // Complete the cutTheSticks function below.
    static List<Integer> cutTheSticks(int[] arr) {

        int len = arr.length, arrayLen = arr.length;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int index = 0, lastIndex = 0;
        int element;

        while(len > 1) {
            list.add(len);
            element = arr[lastIndex];

            while(lastIndex < arrayLen && element == arr[lastIndex]) {
                lastIndex += 1;
            }
            len = arrayLen - lastIndex;
        }

        if(len == 1) {
            list.add(len);
        }

        return list;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter((System.out)));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        List result = cutTheSticks(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

