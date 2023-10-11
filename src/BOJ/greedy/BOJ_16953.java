package BOJ.greedy;

import java.util.*;
import java.io.*;

public class BOJ_16953 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Long a;
    static int b;
    static int result = Integer.MAX_VALUE;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        a = Long.parseLong(input[0]);
        b = Integer.parseInt(input[1]);

        queue.add(new Point(a, 1));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            long num = poll.getNum();
            int cnt = poll.getCnt();

//            System.out.print("num = " + num);
//            System.out.println("cnt = " + cnt);
            if (num == b) {
                result = Math.min(cnt, result);
            }

            if (num * 2 <= b && cnt < result) queue.add(new Point((long) (num * 2), cnt + 1));
            if (num*10 + 1 <= b && cnt < result) queue.add(new Point((long) (num*10 + 1), cnt + 1));

        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static class Point {
        private Long num;
        private int cnt;

        public Point(Long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        public Long getNum() {
            return num;
        }

        public int getCnt() {
            return cnt;
        }
    }
}
