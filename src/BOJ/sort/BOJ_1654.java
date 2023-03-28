package BOJ.sort;

import java.util.*;
import java.io.*;

public class BOJ_1654 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] arr;
    static StringTokenizer st;
    static long max = 0,ans=0,avg=0;
    static int n,m;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max =Math.max(max,arr[i]);
            avg= avg + arr[i];
        }
        avg=avg/n;
        solve(1,avg);
        System.out.println(ans);
    }

    private static void solve(long start, long end) {
        long sum = 0;
        long mid = (start+end)/2;

        if(start>end){
            ans = mid;
            return;
        }
        for (long i : arr) {
            long num = i / mid;

            sum = sum + num;
        }

        if(sum<m){
            solve(start,mid-1);
        }
        else{
            solve(mid+1,end);
        }

    }
}
