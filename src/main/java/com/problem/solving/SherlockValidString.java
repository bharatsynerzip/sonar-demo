package com.problem.solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockValidString {

    // Complete the isValid function below.
/*    static String isValid_old(String s) {

        Map<Character, Integer> characterCountMap = new HashMap<>();
        Character currentCharacter;
        Integer currentCharacterCount;
        int maxCount = 0, minCount = 0;

        for(int index = 0; index < s.length(); index++) {

            currentCharacter = s.charAt(index);
            currentCharacterCount = characterCountMap.get(currentCharacter);

            if(currentCharacterCount == null) {
                characterCountMap.put(currentCharacter, 1);
            } else {
                characterCountMap.put(currentCharacter, currentCharacterCount + 1);
            }
        }

        Set<Character> characterKeySet = characterCountMap.keySet();
        boolean countNotEqual = false;
        String isValue = "YES";
        for(Character character : characterKeySet) {
            currentCharacterCount = characterCountMap.get(character);
            System.out.println("key: " + character + ", value: " + currentCharacterCount);

            if(maxCount == 0 && minCount == 0) {
                maxCount = currentCharacterCount;
                minCount = currentCharacterCount;
            } else {
                *//*if(currentCharacterCount > maxCount) {
                    maxCount = currentCharacterCount;
                } else if(currentCharacterCount < minCount) {
                    minCount = currentCharacterCount;
                }*//*
                if(maxCount != currentCharacterCount) {
                    if(Math.abs(maxCount - currentCharacterCount) > 1 && (currentCharacterCount != 1) {
                        isValue = "NO";
                        break;
                    } else if(countNotEqual) {
                        isValue = "NO";
                        break;
                    } else {
                        countNotEqual = true;
                    }
                }
            }
        }

        return isValue;
    }*/

    static String isValid(String s) {

        Map<Character, Integer> characterCountMap = new HashMap<>();
        Character currentCharacter;
        Integer currentCharacterCount;
        int maxCount = 0, minCount = 0;

        for(int index = 0; index < s.length(); index++) {

            currentCharacter = s.charAt(index);
            currentCharacterCount = characterCountMap.get(currentCharacter);

            if(currentCharacterCount == null) {
                characterCountMap.put(currentCharacter, 1);
            } else {
                characterCountMap.put(currentCharacter, currentCharacterCount + 1);
            }
        }

        Set<Character> characterKeySet = characterCountMap.keySet();
        boolean countNotEqual = false;
        String isValue = "YES";
        Set<Integer> countSet = new HashSet<>();
        int oneCount = 0;
        for(Character character : characterKeySet) {
            currentCharacterCount = characterCountMap.get(character);
            System.out.println("key: " + character + ", value: " + currentCharacterCount);

            if(currentCharacterCount == 1) {
                oneCount += 1;
            }

            countSet.add(currentCharacterCount);
        }

        if(countSet.size() > 2) {
            isValue = "NO";
        } else if(countSet.size() == 2) {
            List<Integer> countArray = new ArrayList(countSet);
            System.out.println(countArray.get(0) - countArray.get(1));

            if((countSet.contains(1) && oneCount > 1)) {
                isValue = "NO";
            } else if((Math.abs(countArray.get(0) - countArray.get(1)) > 1) && !countSet.contains(1)) {
                isValue = "NO";
            }
        }

        return isValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
