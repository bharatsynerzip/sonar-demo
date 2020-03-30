package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NextLexicographicalNumber {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater_old(String w) {

        char[] charArray = w.toCharArray();
        int len = charArray.length;
        char tmpChar;
        int lastReplanceIndex = len;

        for (int index = len-1; index > 0; index--) {
            if (charArray[index] > charArray[index-1]) {
                tmpChar = charArray[index];
                charArray[index] = charArray[index-1];
                charArray[index-1] = tmpChar;
                lastReplanceIndex = index;
                break;
            }
        }

        for (int index = lastReplanceIndex; index < len - 1; index++) {
            if(charArray[index] > charArray[index+1]) {
                tmpChar = charArray[index];
                charArray[index] = charArray[index+1];
                charArray[index+1] = tmpChar;
            }
        }

        String result = new String(charArray);
        return result.equals(w) ? "no answer" : result;
    }

    static String biggerIsGreater(String w) {

        char[] charArray = w.toCharArray();
        int len = charArray.length;
        char tmpChar;
        int i = len - 1, j = len - 1;

        while (i > 0 && (charArray[i] <= charArray[i - 1])) {
            i -= 1;
        }

        if(i == 0) {
            return "no answer";
        }

        /*while(i > 1 && (charArray[i - 1] == charArray[i - 2])) {
            i -= 1;
        }*/

        while(j >= 0 && charArray[j] <= charArray[i-1]) {
            j -= 1;
        }

        //swap two
        tmpChar = charArray[j];
        charArray[j] = charArray[i-1];
        charArray[i-1] = tmpChar;

        j = charArray.length - 1;
        while (i < j) {
            tmpChar = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmpChar;
            i++;
            j--;
        }

        return new String(charArray);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
