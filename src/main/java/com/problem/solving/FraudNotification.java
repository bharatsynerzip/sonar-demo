package com.problem.solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudNotification {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        if(expenditure.length <= d) {
            return 0;
        }

        int[] lastXDaysExpenditure;
        float median2X;
        int notifyCount = 0;

        int[] sortedArray = Arrays.copyOfRange(expenditure, 0, d);
        //Arrays.sort(sortedArray);

        for (int index = d; index < expenditure.length; index++) {

            lastXDaysExpenditure = Arrays.copyOfRange(sortedArray, (index - d), (index));
            //Arrays.sort(lastXDaysExpenditure);
            median2X = findMedianIndex(lastXDaysExpenditure, d) * 2;

            if(median2X <= expenditure[index]) {
                notifyCount += 1;
            }
        }

        return notifyCount;
    }

    public static float findMedianIndex(int[] lastXDaysExpenditure, int d) {

        float medianValue;

        if(d == 0) {
            return 0;
        }

        if(d%2 == 0) {
            int medianLeft = d/2;
            medianValue = ( (float) (lastXDaysExpenditure[medianLeft - 1] + lastXDaysExpenditure[medianLeft]) / 2.0f);
        } else {
            medianValue = lastXDaysExpenditure[d/2];
        }

        return medianValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
