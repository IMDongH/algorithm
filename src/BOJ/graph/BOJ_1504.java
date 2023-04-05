package BOJ.graph;

import java.util.*;
import java.io.*;

public class BOJ_1504 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Edge>[] list;
    static int N,E,V1,V2;
    static StringTokenizer st;
    static int[] dist;

    static final int INF = 200000000;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        dist = new int[N+1];
        Arrays.fill(dist,INF);

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v,w));
            list[v].add(new Edge(u,w));
        }

        st = new StringTokenizer(br.readLine()," ");
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        dijkstra(1);
        long startV1 = dist[V1];
        long startV2 = dist[V2];

        dijkstra(V1);
        long v1E = dist[N];
        long v1V2 = dist[V2];

        dijkstra(V2);
        long v2E = dist[N];

        long num1 = startV1 + v1V2  + v2E;
        long num2 = startV2 + v1V2  + v1E;
        if(num1 >= INF && num2 >= INF) System.out.println(-1);
        else System.out.println(Math.min(num1, num2));
    }

    private static void dijkstra(int st) {
        Arrays.fill(dist,INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(st,0));
        dist[st]=0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();
            if (dist[now.v] < now.w) continue;

            for (Edge edge : list[now.v]) {
                if(dist[edge.v]>now.w+ edge.w){
                    dist[edge.v]=now.w+ edge.w;
                    pq.add(new Edge(edge.v, dist[edge.v]));
                }
            }
        }
    }


    static class Edge implements Comparable<Edge> {

        int v;
        int w;

        public Edge( int v, int w) {

            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v-o.v;
        }
    }
}
