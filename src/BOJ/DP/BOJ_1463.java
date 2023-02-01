package BOJ.DP;

import java.util.*;
import java.io.*;

public class BOJ_1463 {//bottom - up


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(makeOne(num));
    }
    static int makeOne(int n){

        if(n>=2&&n<4){
            return 1;
        }
        else if(n<2){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<=n; i++){

            int min;
            if(i%3==0){
                min = dp[i/3];
                if(i%2==0&&min>dp[i/2]) min = dp[i/2];
                if(min>dp[i-1]) min = dp[i-1];
            }
            else if(i%2==0){
                min = dp[i/2];
                if(min>dp[i-1]) min = dp[i-1];
            }
            else{
                min = dp[i-1];
            }

            dp[i] = min +1;
        }
        return dp[n];
    }
}
