package BOJ.input;

import java.io.*;
import java.util.*;

public class BOJ_11721 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int j=0;
        for(int i=0; i<str.length(); i++){

            sb.append(str.charAt(i));
            if(j>=9){
                j=0;
                sb.append("\n");
            }
            else{
                j++;
            }
        }
        System.out.println(sb);
    }
}
