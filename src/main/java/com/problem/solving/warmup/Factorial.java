package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Factorial {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        BigInteger factorial = BigInteger.ONE;

        for(int number = 1; number <= n; number++) {

            factorial = factorial.multiply(BigInteger.valueOf(number));
        }

        System.out.println(factorial);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}

