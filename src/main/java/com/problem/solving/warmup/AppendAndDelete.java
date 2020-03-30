package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppendAndDelete {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {

        char[] sourceArray = s.toCharArray();
        char[] destArray = t.toCharArray();
        int maxIterationRequired = 0;
        int sourceIndex = 0;
        int destLen = destArray.length;

        for (char sourceChar : sourceArray) {
            if(destLen <= sourceIndex || sourceChar != destArray[sourceIndex]) {
                break;
            }
            sourceIndex += 1;
        }

        maxIterationRequired = (sourceArray.length - sourceIndex) + (destLen - sourceIndex);

        if(maxIterationRequired == k) {
            return "Yes";
        } else {
            return "No";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

