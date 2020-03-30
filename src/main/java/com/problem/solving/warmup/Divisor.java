package com.problem.solving.warmup;

//Divisor

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Divisor {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int numberOfDigit = 0;
        int singleDigit;

        for (char character : charArray) {

            singleDigit = Character.getNumericValue(character);
            if(singleDigit != 0 && (n % singleDigit) == 0) {
                numberOfDigit += 1;
            }
        }

        return numberOfDigit;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
