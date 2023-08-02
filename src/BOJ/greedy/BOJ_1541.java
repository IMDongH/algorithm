package BOJ.greedy;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_1541 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int sum=0;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine(),"-");

        String str = st.nextToken();
        if(str.contains("+")){
            int firstSum = Arrays.stream(str.split("\\+")).mapToInt(Integer::parseInt).sum();
            sum = firstSum;
        }else{
            sum = Integer.parseInt(str);
        }


        while(st.hasMoreTokens()){
            String[] split = st.nextToken().split("\\+");
            int num= Arrays.stream(split).mapToInt(Integer::parseInt).sum();
            sum-=num;
        }

        System.out.println(sum);
    }


}
