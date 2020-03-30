package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ThePrisonerTreats {

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {

        int remainingSweets = (n < m) ? (m % n) : m;
        int savePrisoner;

        if(remainingSweets == 0) {
            savePrisoner = (s - 1) == 0 ? n : (s - 1);
        } else {
            int lastPrisoner = s + remainingSweets - 1;
            savePrisoner = (lastPrisoner > n) ? (lastPrisoner % n) : lastPrisoner;
        }

        return savePrisoner;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

