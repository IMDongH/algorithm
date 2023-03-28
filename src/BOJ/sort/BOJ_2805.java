package BOJ.sort;

import java.util.*;
import java.io.*;

public class BOJ_2805 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static StringTokenizer st;
    static long[] arr;
    static long max =0, ans=0;
    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }

        solve(1,max);
        System.out.println(ans);
    }

    private static void solve(long start,long end){
        long sum=0;
        long mid = (start+end)/2;
        if(start>end) {
            ans = mid;
            return;
        }

        for (long num : arr) {
            sum = sum + (((num-mid)>0)?(num-mid):(0));
        }

        if(m>sum){
            solve(start,mid-1);
        }
        else{
            solve(mid+1,end);
        }


    }
}
