package BOJ.tree;

import java.util.*;
import java.io.*;

public class BOJ_9489 {
    static int n,k;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[] parent;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while(n!=0&&k!=0){
            arr= new int[n+1];
            parent= new int[n+1];
            st = new StringTokenizer(br.readLine()," ");

            arr[0] = -1;
            parent[0] = -1;
            int idx=-1,target=0;
            for(int i=1; i<=n; i++){
                int n = Integer.parseInt(st.nextToken());
                arr[i] = n;
                if(k==arr[i]) target=i;
                if(arr[i-1]+1!=n){//연속되지 않는 경우
                    idx++;
                }
                parent[i] = idx;

            }

            int result =0;
            for(int i=1; i<=n; i++){
                if(parent[i]!=parent[target]
                        &&
                        parent[parent[i]]==parent[parent[target]]){
                    result++;
                }
            }

            System.out.println(result);
            st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());


        }

    }
}
