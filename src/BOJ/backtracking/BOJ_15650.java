package BOJ.backtracking;


import java.io.*;
import java.util.*;


public class BOJ_15650 {

    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        visited = new boolean[n + 1];

        nm(0);

        System.out.println(sb);
    }

    public static void nm(int index) {
        if (m == index) {
//            for (int i = 0; i < m; i++) {
//                sb.append(arr[i]).append(" ");
//            }
            for (int i=0; i<m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = 1; i <= n; i++) {
            if (visited[index]) continue;
            visited[index] = true;
            arr[index]=i;
            nm(i+1);
            visited[index] = false;
        }
    }
}
