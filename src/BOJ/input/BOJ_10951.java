package BOJ.input;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){

            List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            if(list.get(0)==0 && list.get(1)==0){
                break;
            }

            Integer sum = 0;
            for(Integer i : list){
                sum = sum + i;
            }

            sb.append(sum);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
