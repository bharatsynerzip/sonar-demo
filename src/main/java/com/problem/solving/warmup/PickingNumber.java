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

class ResultNumber {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static int pickingNumbers(List<Integer> a) {
        List<Integer> sortedList = a.stream().sorted().collect(toList());
        int maxCount = 0;
        int index = 0, localCount = 0, nextNumber, diff;

        for(Integer number : sortedList) {

            localCount = 1;
            for(int nextIndex = index + 1; nextIndex < sortedList.size(); nextIndex++) {

                diff = sortedList.get(nextIndex) - number;

                if(diff <= 1) {
                    localCount += 1;
                } else {
                    break;
                }
            }

            if(localCount > maxCount) {
                maxCount = localCount;
            }

            index += 1;
        }

        return maxCount;
    }

/*    public static int pickingNumbers(List<Integer> a) {

        Map<Integer, Integer> numberCountMap = new HashMap<>();
        Integer currentNumberCount, lastNumber, nextNumber;

        for(Integer number : a) {

            currentNumberCount = numberCountMap.get(number);

            if(currentNumberCount == null) {
                numberCountMap.put(currentNumberCount, 1);
            } else {
                currentNumberCount += 1;
                numberCountMap.put(currentNumberCount, currentNumberCount);
            }

            lastNumber = numberCountMap.get((currentNumberCount - 1));
            if(lastNumber != null) {
                numberCountMap.put((currentNumberCount - 1), lastNumber + 1);
            }

            nextNumber = numberCountMap.get((currentNumberCount + 1));
            if(nextNumber != null) {
                numberCountMap.put((currentNumberCount +1), lastNumber + 1);
            }
        }

        Set<Integer> keySet = numberCountMap.keySet();
        Integer maxCount = 0;
        for(Integer key : keySet) {

            currentNumberCount = numberCountMap.get(key);

            if(currentNumberCount > maxCount) {
                maxCount = 1;
            }
        }
    }*/

}

public class PickingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter((System.out)));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultNumber.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

