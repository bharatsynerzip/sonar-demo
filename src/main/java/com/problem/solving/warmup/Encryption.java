package com.problem.solving.warmup;

/*public class Encryption {

    public static void main (String args[]) {
        double num = Math.sqrt(10);
        System.out.println((int)num);
    }
}*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {

        String formattedString = s.replace(" ", "");
        int len = formattedString.length();
        int lenSqrt = (int) Math.sqrt(len);
        int row; //= lenSqrt;//(lenSqrt * (lenSqrt + 1)) > len ? lenSqrt : lenSqrt + 1;
        int column; //= row + 1;//(lenSqrt * (lenSqrt + 1)) > len ? row + 1 : row;

        if(lenSqrt * lenSqrt == len) {
            row = lenSqrt;
            column = row;
        } else if((lenSqrt * (lenSqrt + 1)) >= len) {
            row = lenSqrt;
            column = row + 1;
        } else {
            row = lenSqrt + 1;
            column = row;
        }
        StringBuilder encryptedString = new StringBuilder();
        char[][] characterMatrix = new char[row][column];
        int start, pageSize;

        for (int i = 0; i < row; i++) {

            start = i * column;
            pageSize = start + column;
            pageSize = pageSize > len ? len : pageSize;

            characterMatrix[i] = formattedString.substring(start, pageSize).toCharArray();
            System.out.println(characterMatrix[i]);
        }

        for (int j = 0; j < column; j++) {
            encryptedString.append(' ');

            for (int i = 0; i < row; i++) {

                if(((i) * column) + (j + 1) > len) {
                    break;
                } else {
                    encryptedString.append(characterMatrix[i][j]);
                }
            }
        }

        return encryptedString.toString().trim();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


