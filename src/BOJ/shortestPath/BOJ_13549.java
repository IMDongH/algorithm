package BOJ.shortestPath;

import java.util.*;
import java.io.*;


public class BOJ_13549 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k, min = Integer.MAX_VALUE;
    static boolean[] shortest;

    public static void main(String[] args) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        k = input[1];

        shortest = new boolean[100001];
        solve(n);

        System.out.println(min);
    }

    private static void solve(int now) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{now, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int position = poll[0];
            int time = poll[1];
            shortest[position]=true;
            if(position==k){
                min = Math.min(min,time);
            }

            if (position * 2 <= 100000&&!shortest[position*2]) {
                    queue.add(new int[]{position * 2, time});
            }
            if (position + 1 <= 100000&&!shortest[position+1]) {
                    queue.add(new int[]{position + 1, time + 1});
            }
            if (position - 1 >= 0&&!shortest[position-1]) {
                    queue.add(new int[]{position - 1, time + 1});
            }

        }
    }
}
