package com.problem.solving.warmup;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulDays {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {

        int reversedNumber;
        int beautifulDays = 0;

        for(int number = i; number <= j; number++) {

            if((Math.abs(number - reverse(number)) % k) == 0) {
                beautifulDays += 1;
            }
        }

        return beautifulDays;
    }

    private static int reverse(int number) {
        char[] numberStringArray = String.valueOf(number).toCharArray();
        StringBuffer buffer = new StringBuffer();

        for(int index = numberStringArray.length - 1; index >= 0; index--) {
            buffer.append(numberStringArray[index]);
        }

        return Integer.valueOf(buffer.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

