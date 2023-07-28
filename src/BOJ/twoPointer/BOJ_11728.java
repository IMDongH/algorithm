package BOJ.twoPointer;

import java.util.*;
import java.io.*;

public class BOJ_11728 {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] a;
    static int[] b;

    static int[] result;
    static int N,M;

    static int aC=0,bC=0;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        b = new int[M];
        result = new int[N+M];
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<M; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0; i<N+M; i++){
            if(aC>=N){
                sb.append(b[bC] + " ");
                bC++;
                continue;
            }

            if(bC>=M){
                sb.append(a[aC] + " ");
                aC++;
                continue;
            }

            if(a[aC]<b[bC]){
                sb.append(a[aC] + " ");
                aC++;
            }
            else{
                sb.append(b[bC] + " ");
                bC++;
            }
        }

        System.out.println(sb);


    }
}
