package BOJ.tree;

import java.util.*;
import java.io.*;

public class BOJ_17073 {
    static int n, w;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // root 노드
        w = Integer.parseInt(st.nextToken()); // root 노드에 고인 물의 양
        arr = new List[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++){

            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            arr[a].add(b);
            arr[b].add(a);
        }
        int cnt = 0;
        for(int i=1; i<n; i++){ //정점은 한개만 연결될 수도 있으니 i 는 1부터 시
            if(arr[i].size()==1)
                cnt++;
        }
        double result = (double)w/cnt;
        System.out.println(String.format("%.10f", result));


    }
}
