package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LibraryFine {

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        Calendar returnedCalenderDate = getCalenderInstance(d1, m1, y1);
        Calendar expectedCalenderDate = getCalenderInstance(d2, m2, y2);
        int fine = 0;

        if(returnedCalenderDate.compareTo(expectedCalenderDate) > 0) {
            if(y1 > y2) {
                fine = 10000;
            } else if (m1 > m2) {
                fine = 500 * (m1 - m2);
            } else if(d1 > d2) {
                fine = 15 * (d1 - d2);
            }
        }

        return fine;
    }

    static Calendar getCalenderInstance(int d, int m, int y) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DATE, d);
        calendar.set(Calendar.MONTH, m);
        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter((System.out)));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
