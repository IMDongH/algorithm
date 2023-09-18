package BOJ.shortestPath;

import java.util.*;
import java.io.*;

public class BOJ_14938 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, r;
    static List<List<Position>> path;
    static int[] items;
    static StringTokenizer st;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        path = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            path.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int length = Integer.parseInt(input[2]);


            path.get(start).add(new Position(end,length));
            path.get(end).add(new Position(start,length));
        }

        for(int i=1; i<n+1; i++){
            result=Math.max(result,solve(i));
        }
        System.out.println(result);
    }


    private static int solve(int start){
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Position> pq = new PriorityQueue<>();
        int score=0;
        pq.add(new Position(start,0));

        while(!pq.isEmpty()){
            Position position = pq.poll();
            if(visited[position.pos]) continue;

            score+=items[position.pos-1];
            visited[position.pos] = true;

            for (Position nearPos : path.get(position.pos)) {
                if(visited[nearPos.pos]) continue;
                if(nearPos.len+ position.len>m) continue;

                pq.add(new Position(nearPos.pos, position.len+nearPos.len));
            }

        }
        return score;
    }
    private static class Position implements Comparable<Position>{
        private int pos;
        private int len;

        public int getPos() {
            return pos;
        }

        public int getLen() {
            return len;
        }

        public Position(int pos, int len) {
            this.pos = pos;
            this.len = len;
        }

        @Override
        public int compareTo(Position position) {
            return (len - position.getLen());
        }
    }
}
