package BOJ.DP;

import java.util.*;
import java.io.*;

public class BOJ_9095 {

    static int[] dp = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }

    static int dp(int n) {
        if (n > 3) {
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
            return dp[n];
        }
}