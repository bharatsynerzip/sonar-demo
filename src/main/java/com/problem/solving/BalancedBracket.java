package com.problem.solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBracket {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        String isBalancedBracket = "YES";
        Stack<Character> characterStack = new Stack<>();
        Character currentChar, poppedCharacter;

        for (int index = 0; index < s.length(); index++) {
            currentChar = s.charAt(index);

            if(currentChar.equals('(') || currentChar.equals('[') || currentChar.equals('{')) {
                characterStack.push(currentChar);
            } else {

                if(characterStack.isEmpty()) {
                    isBalancedBracket = "NO";
                    break;
                }

                poppedCharacter = characterStack.pop();
                if((currentChar.equals(')') && !poppedCharacter.equals('(')) ||
                        (currentChar.equals(']') && !poppedCharacter.equals('[')) ||
                        (currentChar.equals('}') && !poppedCharacter.equals('{'))) {
                    isBalancedBracket = "NO";
                    break;
                }
            }
        }

        if(!characterStack.isEmpty()) {
            isBalancedBracket = "NO";
        }

        return isBalancedBracket;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}