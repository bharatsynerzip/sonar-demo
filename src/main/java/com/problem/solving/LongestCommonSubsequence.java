package com.problem.solving;

//LongestCommonSubsequence

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LongestCommonSubsequence {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        int firstStrLength = s1.length(), secondStrLength = s2.length();
        int[][] outputArray = new int[s1.length()][s2.length()];
        int maxChildLength = 0;

        for(int firstIndex = 0; firstIndex < s1.length(); firstIndex++) {

//            System.out.println("");
            for (int secondIndex = 0; secondIndex < s2.length(); secondIndex++) {
                boolean isCharEqual = s1.charAt(firstIndex) == s2.charAt(secondIndex);

                if(firstIndex == 0) {
                    if(isCharEqual) {
                        outputArray[firstIndex][secondIndex] = 1;
                    } else if(secondIndex != 0) {
                        outputArray[firstIndex][secondIndex] = outputArray[firstIndex][secondIndex - 1];
                    } else {
                        outputArray[firstIndex][secondIndex] = 0;
                    }
                } else {
                    if(isCharEqual) {
                        if(secondIndex == 0) {
                            outputArray[firstIndex][secondIndex] = 1;
                        } else {
                            outputArray[firstIndex][secondIndex] = outputArray[firstIndex - 1][secondIndex - 1] + 1;
                        }
                    } else if(secondIndex == 0) {
                        outputArray[firstIndex][secondIndex] = outputArray[firstIndex - 1][secondIndex];
                    } else {
                        outputArray[firstIndex][secondIndex] = outputArray[firstIndex][secondIndex - 1] > outputArray[firstIndex - 1][secondIndex] ?
                                outputArray[firstIndex][secondIndex - 1] :
                                outputArray[firstIndex - 1][secondIndex];
                    }
                }

//                System.out.print(" " + outputArray[firstIndex][secondIndex]);
                if(maxChildLength < outputArray[firstIndex][secondIndex]) {
                    maxChildLength = outputArray[firstIndex][secondIndex];
                }
            }
        }

        return maxChildLength;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

