package BOJ.greedy;

import java.util.*;
import java.io.*;
public class BOJ_14916 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,result=0 , min =Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());


        for(int i=n/5; i>=0; i--){// n 이 13 라면 2까지 반복 25 - 5
            if((n-i*5)%2!=0){
                continue;
            }
            for(int j=(n-5*i)/2; j>=0; j--){ // n이 13 이라면 4까지 반복
                if(n-(5*i)-(2*j)==0){
                    min = Math.min(min,i+j);
                }
            }
        }

        if(min!=Integer.MAX_VALUE){
            System.out.println(min);
        }else{
            System.out.println("-1");
        }
    }
}
