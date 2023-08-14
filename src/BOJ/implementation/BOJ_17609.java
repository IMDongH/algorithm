package BOJ.implementation;

import java.util.*;
import java.io.*;

public class BOJ_17609 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static int n;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        for(int k=0; k<n; k++){
            int result =2;
            str = br.readLine();
            if(str.equals(new StringBuilder(str).reverse().toString())) {
                result=0;
            }else {
                if (palindrome(str, 0, str.length()-1)) {
                    result = 1;
                }
            }
            System.out.println(result);
        }
    }

    static boolean palindrome(String str,int s,int e){

        int length = str.length();


        while(s<e){
            if(str.charAt(s)!=str.charAt(e)){
                StringBuilder delL = new StringBuilder(str).deleteCharAt(s);
                StringBuilder delR = new StringBuilder(str).deleteCharAt(e);

                if(delL.toString().equals(delL.reverse().toString())||delR.toString().equals(delR.reverse().toString())){
                    return true;
                }
                return false;
            }
            s++;
            e--;

        }
        return false;
    }

}
