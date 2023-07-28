package BOJ.twoPointer;

import java.util.*;
import java.io.*;

public class BOJ_20922 {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[] count = new int[100001];
    static int N,K,len=0,s=0,e=0;
    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr= new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(e<N){

            if(count[arr[e]]+1<=K){
                count[arr[e]]++;
                e++;
            }
            else{
                count[arr[s]]--;
                s++;
            }
            if(len<e-s){
                len = e-s;
            }
        }

        System.out.println(len);
    }
}
