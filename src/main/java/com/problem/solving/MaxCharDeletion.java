package com.problem.solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxCharDeletion {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        if(s == null || s.length() < 2) {
            return 0;
        }

        int maxDeletionRequired = 0;
        char lastCharacter = s.charAt(0), currentChar;

        for (int index = 1; index < s.length(); index++) {
            currentChar = s.charAt(index);

            if(lastCharacter == currentChar) {
                maxDeletionRequired += 1;
            } else {
                lastCharacter = currentChar;
            }
        }

        return maxDeletionRequired;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}