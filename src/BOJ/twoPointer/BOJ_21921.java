package BOJ.twoPointer;

import java.io.*;
import java.util.*;

public class BOJ_21921 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N=0,X=0,s=0,e=0;
    static int[] visitor;
    static int max=0,count=1, result=0;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        e=X-1;

        st = new StringTokenizer(br.readLine()," ");
        visitor = new int[N];
        for(int i=0; i<N; i++)
        {
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<X; i++){
            max = max + visitor[i];
        }

        result = max;
        while(e<N-1){
             result = result - visitor[s] + visitor[e+1] ;

            if(result == max){
                count++;
            }else if(result>max){
                max=result;
                count = 1;
            }
            s++;
            e++;
        }

        if(max==0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }
    }

}

