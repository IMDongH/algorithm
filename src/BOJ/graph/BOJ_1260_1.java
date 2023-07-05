package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260_1 {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static int n,m,v;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());


        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            graph[i]= new ArrayList<>();
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(graph[i]);
        }
        
        dfs(v);
        System.out.println();
        Arrays.fill(visited,false);
        bfs(v);
    }

    private static void dfs(int startN) {
        visited[startN] = true;
        System.out.print(startN + " ");
        ArrayList<Integer> integers = graph[startN];
        for (Integer integer : integers) {
            if(!visited[integer]){
                dfs(integer);
            }
        }
    }

    private static void bfs(int startN) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startN);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            if(!visited[poll]){
                System.out.print(poll + " ");
                visited[poll]=true;
                ArrayList<Integer> integers = graph[poll];
                for (Integer integer : integers) {
                    if(!visited[integer]){
                        queue.add(integer);
                    }
                }
            }

        }
    }
}
