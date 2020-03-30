package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MigratoryBird {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        if(arr == null) {
            return 0;
        }

        Map<Integer, Long> countingMap = arr.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        int minValue = 0;
        Long maxCount = 0l, value;

        for(Integer key : countingMap.keySet()) {
            value = countingMap.get(key);

            if(value > maxCount) {
                maxCount = value;
                minValue = key;
            } else if(value == maxCount && minValue > key) {
                minValue = key;
            }
        }

        return minValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
