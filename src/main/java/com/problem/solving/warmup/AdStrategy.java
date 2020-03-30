package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AdStrategy {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {

        // First share with 5
        int peopleCount = 5;
        int likeCount = 0, dayLikeCount;

        for (int index = 1; index <= n; index++) {

            dayLikeCount = (int) Math.floor(peopleCount/2);
            likeCount += dayLikeCount;
            peopleCount = dayLikeCount * 3;
        }

        return likeCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

