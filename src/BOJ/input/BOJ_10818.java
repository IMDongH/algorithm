package BOJ.input;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class BOJ_10818 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int max = list.get(0);
        int min = list.get(0);
        for (int i=0; i<line; i++) {
            if(list.get(i)>max){
                max = list.get(i);
            }
            else if(list.get(i)<min){
                min = list.get(i);
            }
        }

        System.out.println(min + " " + max);
    }
}
