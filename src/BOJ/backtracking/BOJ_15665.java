package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_15665 {

    static int N,M;
    static StringBuilder sb;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[] record;
    static boolean[] visited;
    static LinkedHashSet<String> ans;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        record = new int[N+1];
        visited = new boolean[N+1];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        nm(0,1);

        ans.forEach(System.out::println);
    }
    public static void nm(int index,int nxtIdx){
        if(M==index){
            sb = new StringBuilder();
            for(int i=0; i<M; i++){
                sb.append(arr[record[i]]).append(" ");
            }
            ans.add(sb.toString());
            return;
        }

        for(int i=nxtIdx; i<=N; i++){
//            if (visited[i]) continue;
            visited[i] = true;
            record[index] = i;
            nm(index+1,i);
            visited[i] = false;
        }
    }
}
