package BOJ.DP;

import java.util.*;
import java.io.*;

public class BOJ_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(dp(num));

    }

    static int dp(int n) {
        int[] dp = new int[n + 1];


        if (0 <= n && n < 3) {
            return n;
        } else if (n >= 3) {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }

            return dp[n];
        }

        return n;
    }
}
