package BOJ.implementation;

import java.util.*;
import java.io.*;

public class BOJ_12919 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s,t;
    static int result =0;
    public static void main(String[] args) throws IOException{

        s = br.readLine();
        t = br.readLine();

        solve(s);
        System.out.println(result);
    }

    static void solve(String str){
//        System.out.println(str);
        if(str.length()==t.length()){
            if(str.equals(t)){
                result=1;
            }
            return;
        }

        StringBuilder sb = new StringBuilder();

        String condition1 = sb.append(str).append("A").toString();

        if(t.contains(condition1)){
            solve(condition1);
        }
        else if(t.contains(reverseString(condition1))){
            solve(condition1);
        }
        sb = new StringBuilder();
        String condition2 = sb.append(str).append("B").reverse().toString();
//        System.out.println(condition2);
        if(t.contains(condition2)){
            solve(condition2);
        }
        else if(t.contains(reverseString(condition2))){
            solve(condition2);
        }
    }

    static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
