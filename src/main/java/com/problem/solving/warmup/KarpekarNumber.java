package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class KarpekarNumber {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }

    static void kaprekarNumbers(int p, int q) {

        boolean isInvalidRange = true;

        while (p <= q) {

            if(isKaprekar(p)) {
                System.out.print(p + " ");
                isInvalidRange = false;
            }

            p += 1;
        }

        if(isInvalidRange) {
            System.out.print("INVALID RANGE");
        }
    }

    private static boolean isKaprekar(int num) {
        long squared = (long) num * num;
        String numberInStr   = String.valueOf(squared);
        String leftStr  = numberInStr.substring(0, numberInStr.length() / 2);
        String rightStr = numberInStr.substring(numberInStr.length() / 2);
        int numL = (leftStr.isEmpty())  ? 0 : Integer.parseInt(leftStr);
        int numR = (rightStr.isEmpty()) ? 0 : Integer.parseInt(rightStr);
        if (numL + numR == num) {
            return true;
        } else {
            return false;
        }
    }
}
