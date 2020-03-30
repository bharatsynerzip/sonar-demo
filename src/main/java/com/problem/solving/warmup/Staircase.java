package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {

        StringBuilder stringBuilder;

        for (int index = 1; index <= n; index++) {
            System.out.println(new StringBuilder(new String(new char[n]).replace('\0', ' ')).replace(n-index, n, new String(new char[index]).replace('\0', '#')));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
