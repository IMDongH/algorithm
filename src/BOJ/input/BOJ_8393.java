package BOJ.input;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class BOJ_8393 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int sum = 0;

        for(int i=1; i<=num; i++){
            sum = sum+i;
        }
        System.out.println(sum);
    }
}
