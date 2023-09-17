package BOJ.DP;

import java.util.*;
import java.io.*;

public class BOJ_9251 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String a,b;

    static int[][] result;
    static int max = 0;

    public static void main(String[] args) throws IOException{
        a = br.readLine();
        b = br.readLine();
        result = new int[a.length()+1][b.length()+1];

        solve();
        System.out.println(max);
    }

    private static void solve(){
        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    result[i][j] = result[i-1][j-1]+1;
                }
                else{
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                }

                max = Math.max(max,result[i][j]);
            }
        }
    }
}
