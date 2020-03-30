package com.problem.solving.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueenAttack {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + '}';
        }
    }

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        List<Point> attackerPlaces = new ArrayList<>();
        int attackerI = 0, attackerJ = 0;
        Point point;

        // create point array of obstacles
        List<Point> obstacleList = new ArrayList<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleList.add(new Point(obstacles[i][0], obstacles[i][1]));
        }

        // left horizontal
        int obstacleLen = obstacleList.size();
        for (int i = c_q - 1; i > 0; i--) {
            point = new Point(r_q, i);

            if(obstacleLen != 0 && contain(obstacleList, point)) {
                break;
            } else {
                attackerPlaces.add(point);
            }
        }

        // right horizontal
        for (int i = c_q + 1; i <= n; i++) {
            point = new Point(r_q, i);

            if(obstacleLen != 0 && contain(obstacleList, point)) {
                break;
            } else {
                attackerPlaces.add(point);
            }
        }

        // bottom vertical
        for (int i = r_q - 1; i > 0; i--) {
            point = new Point(i, c_q);

            if(obstacleLen != 0 && contain(obstacleList, point)) {
                break;
            } else {
                attackerPlaces.add(point);
            }
        }

        // right horizontal
        for (int i = r_q + 1; i <= n; i++) {
            point = new Point(i, c_q);

            if(obstacleLen != 0 && contain(obstacleList, point)) {
                break;
            } else {
                attackerPlaces.add(point);
            }
        }

        for (int i = r_q - 1, j = c_q - 1; i > 0 && j > 0; i--, j--) {
            point = new Point(i, j);

            if(obstacleLen != 0 && contain(obstacleList, point)) {
                break;
            } else {
                attackerPlaces.add(point);
            }
        }

        for (int i = r_q + 1, j = c_q + 1; i <= n && j <= n; i++, j++) {
            point = new Point(i, j);

            if(obstacleLen != 0 && contain(obstacleList, point)) {
                break;
            } else {
                attackerPlaces.add(point);
            }
        }

        for (int i = r_q + 1, j = c_q - 1; i <= n && j > 0; i++, j--) {
            point = new Point(i, j);

            if(obstacleLen != 0 && contain(obstacleList, point)) {
                break;
            } else {
                attackerPlaces.add(point);
            }
        }

        for (int i = r_q - 1, j = c_q + 1; i > 0 && j <= n; i--, j++) {
            point = new Point(i, j);

            if(obstacleLen != 0 && contain(obstacleList, point)) {
                break;
            } else {
                attackerPlaces.add(point);
            }
        }

        attackerPlaces.stream().forEach(System.out::println);

        return attackerPlaces.size();
    }

    private static boolean contain(List<Point> obstacleList, Point point) {

        return obstacleList.stream().filter(obstaclePoint -> obstaclePoint.equals(point)).findFirst().isPresent();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

