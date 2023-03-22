package BOJ.bruteforce;

import java.util.*;
import java.io.*;

public class BOJ_2839 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException{

        int n = Integer.parseInt(br.readLine());
        solve(n);
        if(min==Integer.MAX_VALUE){
            System.out.println("-1");
        }
        else{
            System.out.println(min);
        }

    }

    private static void solve(int n) {
        for(int i=0; i<=n/5; i++){
            for(int j=0; j<=n/3; j++){
                int s = i*5 + j*3;
                if(s==n){
                    min = i+j;
                } else if (s>n) {
                    break;
                }
            }
        }
    }
}
