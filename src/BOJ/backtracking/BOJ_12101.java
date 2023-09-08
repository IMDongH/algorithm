package BOJ.backtracking;

import java.util.*;
import java.io.*;

public class BOJ_12101 {

    static int n,k,cnt=0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] result = new int[11];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        solve(0,0,result);

        System.out.println("-1");
    }

    private static void solve(int idx, int sum, int[] record){
        if(sum == n){
            cnt++;
            if(cnt == k){
                for(int i=0; i<idx; i++){
                    sb.append(record[i]);
                    if(i!=idx-1)
                        sb.append("+");
                }
                System.out.println(sb);
                System.exit(0);
            }
        }

        for(int i=1; i<=3; i++){
            if(sum+i<=n){
                record[idx] = i;
                solve(idx+1,sum+i,record);

            }
        }
    }
}
