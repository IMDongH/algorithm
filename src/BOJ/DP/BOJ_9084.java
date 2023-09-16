package BOJ.DP;

import java.util.*;
import java.io.*;


public class BOJ_9084 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,amount;
    static int[] coins;
    static int[] result;
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            Integer.parseInt(br.readLine());
            coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            amount = Integer.parseInt(br.readLine());
            result = new int[amount+1];
            solve();
        }

    }
    private static void solve() {
        for (int coin : coins) {
            for(int i=1; i<=amount; i++){
                if(i-coin==0){
                    result[i]++;
                    continue;
                }

                if(i<coin) continue;

                result[i] = result[i] + result[i-coin];
            }
        }
        System.out.println(result[amount]);
    }
}
