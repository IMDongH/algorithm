package BOJ.divideAndconquer;

import java.io.*;
import java.util.*;
public class BOJ_1629 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long a,b,c;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine()," ");

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(solve(b));
    }

    static long solve(long n) {
        if(n==1){
            return a%c;
        }
        long temp = solve(n/2);;
        if(n%2==1){

            return (temp*temp%c)*a%c;
        }
            return temp*temp%c;


    }
}
