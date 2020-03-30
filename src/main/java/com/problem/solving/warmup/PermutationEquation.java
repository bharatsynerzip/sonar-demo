package com.problem.solving.warmup;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PermutationEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {

        int len = p.length;
        int[] permutationArray = new int[len];
        AtomicInteger counter = new AtomicInteger(1);
        Map<Integer, Integer> valueIndexMap = Arrays.stream(p).boxed().collect(Collectors.toMap(i -> i, i -> counter.getAndAdd(1)));

        int index = 0, x = 1;
        for (int number : p) {
            permutationArray[index++] = valueIndexMap.get(valueIndexMap.get(x++));
        }

        return permutationArray;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}