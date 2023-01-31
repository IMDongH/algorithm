package BOJ.input;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class BOJ_11720 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String line = null;

        int length = Integer.parseInt(br.readLine());
        String num =br.readLine();

        int sum =0;
        for(int i=0; i<length; i++){
            sum = sum +Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        System.out.print(sum);
    }
}
