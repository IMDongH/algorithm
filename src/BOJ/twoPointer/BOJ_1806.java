package BOJ.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,S,len= Integer.MAX_VALUE,s=0,e=0,sum=0,minLen=0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr=  new int[N+1];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(e<=N){
            if(sum>=S){
                sum-=arr[s++];
                if(len>e-s+1)
                    len = e-s+1;
            }
            else{
                sum+=arr[e++];
            }
        }

        if(len == Integer.MAX_VALUE){
            System.out.println(0);
        }else{

            System.out.println(len);
        }
    }
}
