package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class OrganizingContainerBalls {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {

        int typeOfBallCount = container.length;
        int containerBallCount, ballTypeCount;
        Map<Integer, Integer> containerCountMap = new HashMap<>();
        List<Integer> containersBallCount = new ArrayList<>();
        Integer ballCountByType;



        for (int i = 0; i < container.length; i++) {
            containerBallCount = 0;

            for (int j = 0; j < container[i].length; j++) {

                ballTypeCount = container[i][j];
                containerBallCount += ballTypeCount;
                ballCountByType = containerCountMap.get(j);

                if(ballCountByType == null) {
                    containerCountMap.put(j, ballTypeCount);
                } else {
                    containerCountMap.put(j, ballCountByType + ballTypeCount);
                }
            }

            containersBallCount.add(containerBallCount);
        }

        Set<Integer> keys = containerCountMap.keySet();
        for (Integer key: keys) {
            ballCountByType = containerCountMap.get(key);

            if(!containersBallCount.remove(ballCountByType)) {
                return "Impossible";
            }
        }

        return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

