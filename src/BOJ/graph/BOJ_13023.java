package BOJ.graph;

import java.util.*;
import java.io.*;

/**
 * 처음에 array 를 사용 했는데 for 문이 n만큼 반복되어서 시간초과가 발생함 -> list 로 변경 했을 때 방문할 수 있는 수 만큼만 반복하기 때문에 시간초과가 발생하지 않음
 */
public class BOJ_13023 {
    static int n, m;

    private static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int result=0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < n; i++) {
            if(result==0) {
                visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int end,int idx) {

        if(idx ==5){
            result=1;
            return;
        }
        for (Integer i : arr[end]) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i,idx+1);
                visited[i] = false;
            }
        }

    }
}
