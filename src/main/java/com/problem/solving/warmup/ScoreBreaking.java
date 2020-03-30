package com.problem.solving.warmup;

//ScoreBreaking
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ScoreBreaking {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {

        if(scores == null || scores.length == 0) {
            return new int[] {0, 0};
        }

        int min = scores[0], max = scores[0];
        int minBreak = 0, maxBreak = 0;

        for(int score : scores) {
            if(min > score) {
                min = score;
                minBreak += 1;
            }

            if(max < score) {
                max = score;
                maxBreak += 1;
            }
        }

        return new int[] {maxBreak, minBreak};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
