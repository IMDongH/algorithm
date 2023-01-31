package BOJ.input;

import java.util.*;
import java.io.*;

public class BOJ_2739 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<=9; i++){
            sb.append(num + " * " + i + " = "  + num*i +"\n");
        }
        System.out.println(sb);
    }

}
