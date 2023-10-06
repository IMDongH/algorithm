package BOJ.shortestPath;

import java.util.*;
import java.io.*;


public class BOJ_17396 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static List<List<Point>> path = new ArrayList<>();
    static Long[] visible, shortest;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String[] init = br.readLine().split(" ");
        n = Integer.parseInt(init[0]);
        m = Integer.parseInt(init[1]);

        shortest = new Long[n];
        visible = new Long[n];

        for(int i=0; i<n; i++){
            path.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            visible[i] = Long.parseLong((st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            path.get(input[0]).add(new Point(input[1], (long) input[2]));
            path.get(input[1]).add(new Point(input[0], (long) input[2]));
        }

        for(int i=0; i<n; i++){
            path.get(i).sort((o1,o2)-> Math.toIntExact(o1.getLen() - o2.getLen()));
        }

        Arrays.fill(shortest,Long.MAX_VALUE);
        shortest[0] = 0L;
        solve();


        if(shortest[n-1]==Long.MAX_VALUE){
            System.out.println("-1");
        }else {
            System.out.println(shortest[n-1]);
        }
    }

    private static void solve() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0L));

        while(!pq.isEmpty()){
            Point poll = pq.poll();
            if(poll.getLen()>shortest[poll.getDes()]||poll.getDes()==n) continue;

            for (Point point : path.get(poll.getDes())) {
                if(visible[poll.getDes()]==1) continue;

                if(shortest[point.getDes()]>shortest[poll.getDes()]+point.getLen()){
                    shortest[point.getDes()] = shortest[poll.getDes()]+point.getLen();
                    pq.add(new Point(point.getDes(), shortest[point.getDes()]));
                }
            }
        }
    }

    private static class Point implements Comparable<Point> {
        private int des;
        private Long len;

        public Point(int des, Long len) {
            this.des = des;
            this.len = len;
        }

        public int getDes() {
            return des;
        }

        public Long getLen() {
            return len;
        }

        @Override
        public int compareTo(Point o) {
            return Math.toIntExact(this.len - o.getLen());
        }
    }
}
