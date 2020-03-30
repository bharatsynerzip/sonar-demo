package com.problem.solving;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class FindMaxRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        long largestArea = 0l, calculatedArea, totalLength = h.length;
        int removedElementCount;
        //Arrays.sort(h);
        //IntStream.of(h).forEach(System.out::println);
        Stack<Integer> heightStack = new Stack<>();

        for(int index = 0; index < totalLength; index++) {

            if(heightStack.isEmpty()) {
                heightStack.push(h[index]);
            } else {

                if (heightStack.peek() < h[index]) {
                    heightStack.push(h[index]);
                } else {

                    calculatedArea = 0l;
                    removedElementCount = 0;

                    while (!heightStack.isEmpty() && heightStack.peek() > h[index]) {
                        heightStack.pop();
                        removedElementCount += 1;
                    }

                    calculatedArea = heightStack.peek() * removedElementCount;
                    if (calculatedArea > largestArea) {
                        largestArea = calculatedArea;
                    }

                    while (removedElementCount != 0) {
                        heightStack.push(h[index]);
                        removedElementCount -= 1;
                    }
                    heightStack.push(h[index]);
                }
            }
        }

        calculatedArea = 0;
        removedElementCount = 0;
        int lastElement = 0;
        while (!heightStack.isEmpty()) {
            lastElement = heightStack.pop();
            removedElementCount += 1;
        }

        calculatedArea = lastElement * removedElementCount;
        if(calculatedArea > largestArea) {
            largestArea = calculatedArea;
        }


        /*for(int index = 0; index < totalLength; index++) {
            calculatedArea = h[index] * (totalLength - index);

            if(calculatedArea > largestArea) { //26152
                largestArea = calculatedArea;
            }
        }*/

        return  largestArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
