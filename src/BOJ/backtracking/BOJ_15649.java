package BOJ.backtracking;


import java.io.*;
import java.util.*;

public class BOJ_15649 {

    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new int[n];

        nm(0,0);

        System.out.println(sb);
    }

    public static void nm(int index,int cnt) {
        if (index == m) {
            for(int i = 0; i < m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = cnt+1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[index] = i;
            nm(index+1,i);
            visited[i] = false;
        }
    }

}
