package BOJ.shortestPath;

import java.util.*;
import java.io.*;

public class BOJ_1865 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t, n, m, w;
    static List<List<Point>> path ;
    static StringTokenizer st;
    static long[] shortest;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            shortest = new long[n + 1];
            Arrays.fill(shortest, Integer.MAX_VALUE);
            shortest[1] = 0;

            path = new ArrayList<>();
            for (int k = 0; k <= n; k++) {
                path.add(new ArrayList<>());
            }

            for (int j = 0; j < m; j++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                path.get(input[0]).add(new Point(input[1], input[2]));
                path.get(input[1]).add(new Point(input[0], input[2]));
            }
            for (int j = 0; j < w; j++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                path.get(input[0]).add(new Point(input[1], -input[2]));
            }

            if(solve()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }

    private static boolean solve() {
        for (int j = 1; j < n; j++) {
            for (int i = 1; i <= n; i++) {
                List<Point> points = path.get(i);
                for (Point point : points) {
//                    if(shortest[i]==Integer.MAX_VALUE) continue;
                    if (shortest[i] + point.getLen() < shortest[point.getDes()]) {
                        shortest[point.getDes()] = shortest[i] + point.getLen();
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            List<Point> points = path.get(i);
            for (Point point : points) {
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

