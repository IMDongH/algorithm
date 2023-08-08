package BOJ.graph;

import java.util.*;
import java.io.*;

public class BOJ_2668 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, count = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=n; i++){

            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }


        Collections.sort(result);
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static void dfs(int start, int target) {

        if(arr[start]==target) result.add(target);

        if(!visited[arr[start]]){
            visited[arr[start]]=true;
            dfs(arr[start],target);
            visited[arr[start]]=false;
        }
    }
}
