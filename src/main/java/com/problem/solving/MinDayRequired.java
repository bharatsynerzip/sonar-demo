package com.problem.solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinDayRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {

        if(goal <= 0) {
            return 0;
        }

        int runningDay = 0;
        long completedOrder = 0, dayCompletedOrder;

        while (goal > completedOrder) {

            runningDay += 1;
            dayCompletedOrder = 0;

            for (int index = 0; index < machines.length; index++) {
                if((runningDay % machines[index]) == 0) {
                    dayCompletedOrder += 1;
                }
            }

            completedOrder += dayCompletedOrder;
        }

        return runningDay;
    }

    static long minTimeTry(long[] machines, long goal) {

        if(goal <= 0) {
            return 0;
        }

        double orderCompletedInOneDay = 0;

        for (int index = 0; index < machines.length; index++) {
            orderCompletedInOneDay += (1.0 / (double) machines[index]);
        }

        System.out.println(orderCompletedInOneDay);
        double numberOfDaysInFloat = (goal / orderCompletedInOneDay);
        if((numberOfDaysInFloat / (long) numberOfDaysInFloat) > 1){
            numberOfDaysInFloat += 1;
        }

        return (long)numberOfDaysInFloat;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

