package BOJ.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2470 {

    static int N;
    static Integer[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int min= Integer.MAX_VALUE,s=0,e=1,recordS=0,recordE=0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr= new Integer[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(Math::abs));


        while(e<N){
            if(min>Math.abs(arr[s] + arr[e])){
                min = Math.abs(arr[s] + arr[e]);
                recordS = arr[s];
                recordE = arr[e];
            }

            s++;
            e++;
        }

        if(recordS>recordE){
            System.out.println(recordE + " " + recordS);
        }else{
            System.out.println(recordS + " " + recordE);
        }
    }
}
