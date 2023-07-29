package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {

    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[] record;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        record = new int[N+1];
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        nm(0);

        System.out.println(sb);
    }
    public static void nm(int index){
        if(M==index){
            for(int i=0; i<M; i++){
                sb.append(arr[record[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if (visited[i]) continue;
            visited[i] = true;
            record[index] = i;
            nm(index+1);
            visited[i] = false;
        }
    }
}
