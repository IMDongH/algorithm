package BOJ.DP;


import java.util.*;
import java.io.*;

public class BOJ_15486 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N , max = 0;
    static int[][] arr;
    static StringTokenizer st;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][2];
        dp = new int[N+2];

        for(int i=1; i<=N; i++){
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        for(int i=N; i>=1; i--){
            if(i+arr[i][0]-1<=N){
                dp[i] = Math.max(arr[i][1] + (
                        i+arr[i][0]<=N ? dp[i+arr[i][0]] : 0)
                        , dp[i+1]);
            } else {
                dp[i] = dp[i+1];
            }
        }


        System.out.println(Arrays.stream(dp).max().orElse(0));
    }


}
