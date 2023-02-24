package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int vN;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int startN;


    static int nN;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        vN = Integer.parseInt(st.nextToken()); //정점 수
        nN = Integer.parseInt(st.nextToken()); //간선 수
        startN = Integer.parseInt(st.nextToken()); //시작 지점

        graph = new ArrayList[vN + 1];
        visited = new boolean[vN + 1];
        for (int i = 0; i <= vN; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < nN; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());

            graph[start].add(des);
            graph[des].add(start);
        }


        for(int i =1; i<=vN; i++){
            Collections.sort(graph[i]);
        }
        dfs(startN);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(startN);
    }

    private static void dfs(int startN){
        System.out.print(startN + " ");
        visited[startN] = true;
        for (Integer integer : graph[startN]) {
            if(!visited[integer]){
                dfs(integer);
            }
        }
    }

    private static void bfs(int startN){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startN);
        visited[startN]  = true;

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            System.out.print(poll + " ");
            for (Integer integer : graph[poll]) {
                if(!visited[integer]){
                    visited[integer] = true;
                    queue.add(integer);
                }
            }
        }
    }
}
