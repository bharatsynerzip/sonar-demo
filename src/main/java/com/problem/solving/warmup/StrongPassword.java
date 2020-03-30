package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StrongPassword {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        boolean isDigitPresent = false, isCapitalCasePresent = false, isSmallCasePresent = false, isSpecialCharPresent = false;
        int typesOfCharacter = 0;
        String specialChar = "!@#$%^&*()-+";

        for (int intValue : password.toCharArray()) {

            if(intValue >= 97 && intValue <= 122 && !isSmallCasePresent) {
                isSmallCasePresent = true;
                typesOfCharacter += 1;
            } else if(intValue >= 65 && intValue <= 90 && !isCapitalCasePresent) {
                isCapitalCasePresent = true;
                typesOfCharacter += 1;
            } else if(intValue >= 48 && intValue <= 57 && !isDigitPresent) {
                isDigitPresent = true;
                typesOfCharacter += 1;
            } else if (!isSpecialCharPresent && specialChar.contains(Character.toString((char) intValue))) {
                isSpecialCharPresent = true;
                typesOfCharacter += 1;
            }
        }

        int remainingChar = 4 - typesOfCharacter;
        int minNumber = n > 6 ? (remainingChar) : (( n + remainingChar) > 6 ) ? remainingChar : (6 - n);

        return minNumber;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        /*int number = '@'; // a-97, z-122, A-65, Z-90, 0-48, 9-57, !@#$%^&*()-+
        System.out.println( (char) number);*/
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
