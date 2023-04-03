package BOJ.graph;

import java.util.*;
import java.io.*;

public class BOJ_1753 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E, start;
    static StringTokenizer st;
    static ArrayList<Edge>[] arr;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        arr = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[u].add(new Edge(v, w));
        }
        dist[start] = 0;

        dijkstra(start);

        for(int i=1; i<dist.length; i++){
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }


    private static void dijkstra(int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (Edge edge : arr[now.v]) {
                if (dist[edge.v] > now.w + edge.w) {
                    dist[edge.v] = now.w + edge.w;
                    pq.add(new Edge(edge.v, dist[edge.v]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w) {

            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "graph{" +

                    ", v=" + v +
                    ", w=" + w +
                    '}';
        }


        @Override
        public int compareTo(Edge o) {
            return this.v-o.v;
        }
    }
}
