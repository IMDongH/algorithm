package BOJ.shortestPath;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_18352 {

    static int n, m, k, x;
    static List<Integer>[] path;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] shortest;

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]); //노드
        m = Integer.parseInt(input[1]); //간선
        k = Integer.parseInt(input[2]); //최단거리
        x = Integer.parseInt(input[3]); //출발 노드

        path = new List[n + 1];
        shortest = new int[n + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            path[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] point = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            path[point[0]].add(point[1]);
        }

        shortest[x] = 0;
        solve(x);

    }

    private static void solve(int now) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(now);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            for (Integer integer : path[poll]) {
                if(shortest[integer]==Integer.MAX_VALUE){
                    shortest[integer] = shortest[poll]+1;
                    queue.add(integer);
                }
            }
        }

        boolean flag = false;
        for(int i=1; i<=n; i++){
            if(shortest[i]==k) {
                System.out.println(i);
                flag=true;
            }
        }
        if(!flag) System.out.println(-1);
    }
}


