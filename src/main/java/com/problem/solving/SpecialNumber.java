package com.problem.solving;

//SpecialNumber

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class SpecialNumber {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {

        if(n.isEmpty()) {
            return 0;
        }

        if(k != 0) {
            n = String.join("", Collections.nCopies(k, n));
        }

        long len = n.length();
        System.out.println(n);

        if(len == 1) {
            return Integer.valueOf(n);
        } else {
            int sum = 0;
            for (char character : n.toCharArray()) {
                sum += Integer.valueOf(character + "");
            }

            return superDigit(String.valueOf(sum), 0);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
