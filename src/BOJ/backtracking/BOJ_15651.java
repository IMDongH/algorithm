package BOJ.backtracking;

import java.util.*;
import java.io.*;

public class BOJ_15651 {

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

        arr = new int[n+1];
        nm(0);

        System.out.println(sb);
    }

    public static void nm(int index){
        if(m==index){
            for(int i=0; i<m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            arr[index] = i;
            nm(index+1);
        }
    }
}
