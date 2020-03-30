package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class KangarooMove {

    // Complete the kangaroo function below.
    //x1 + y * v1 = x2 + y * v2 where "y" is number of jumps... so if (x1 - x2) % (v2 - v1) == 0 then our kangaroos will meet each other : )
    static String kangaroo(int x1, int v1, int x2, int v2) {

        float numberOfJump = (float) (x1 - x2) / (v2 - v1);

        System.out.println(numberOfJump);
        if(numberOfJump < 0) {
            return "NO";
        } else if (numberOfJump % 1 == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
