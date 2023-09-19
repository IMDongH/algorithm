package BOJ.DP;

import java.util.*;
import java.io.*;

public class BOJ_2225 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static final int div = 1000000000;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        dp = new int[k+1][n+1]; //k개를 더해서 합이 n이 되는 경우 저장

        for(int i=0; i<=n; i++){
            dp[1][i] =1;
        }

        for(int i=1; i<=k;i++){
            for(int j=0; j<=n; j++){
                for(int l=0;l<=j;l++) {
                    dp[i][j] = dp[i][j]%div +  dp[i-1][j-l]%div;
                }
            }
        }

        System.out.println(dp[k][n]%div);
    }
}
