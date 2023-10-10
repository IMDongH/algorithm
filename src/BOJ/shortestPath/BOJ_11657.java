package BOJ.shortestPath;

import java.util.*;
import java.io.*;

public class BOJ_11657 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static List<List<Point>> path = new ArrayList<>();
    static long[] shortest;

    public static void main(String[] args) throws IOException {
        String[] init = br.readLine().split(" ");
        n = Integer.parseInt(init[0]);
        m = Integer.parseInt(init[1]);
        shortest = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            path.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            path.get(input[0]).add(new Point(input[1], input[2]));
//            path.get(input[1]).add(new Point(input[0], input[2]));
        }

        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[1] = 0;

        boolean flag = solve();

        if(flag){
            System.out.println(-1);
        }else{
            for(int i=2; i<=n; i++){
                if(shortest[i]==Integer.MAX_VALUE){
                    shortest[i] = -1;
                }
                System.out.println(shortest[i]);
            }
        }


    }

    private static boolean solve() {

        for (int j = 1; j < n; j++) {
            for (int i = 1; i <= n; i++) {
                List<Point> points = path.get(i);
                for (Point point : points) {
                    if(shortest[i]==Integer.MAX_VALUE) continue;
                    if (shortest[i] + point.getLen() < shortest[point.getDes()]) {
                        shortest[point.getDes()] = shortest[i] + point.getLen();
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            List<Point> points = path.get(i);
            for (Point point : points) {
                if(shortest[i]==Integer.MAX_VALUE) continue;
                if (shortest[i] + point.getLen() < shortest[point.getDes()]) {
                    return true;
                }
            }
        }

        return false;
    }

    private static class Point {


        private int des;
        private int len;

        public Point(int des, int len) {
            this.des = des;
            this.len = len;
        }

        public int getDes() {
            return des;
        }

        public int getLen() {
            return len;
        }


    }
}
