package BOJ.input;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_11021 {

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<=num; i++){
            List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int sum = 0;
            for(Integer data : list){
                sum = sum + data;
            }
            sb.append("Case #"+i+": "+ sum+"\n");
        }
        System.out.print(sb);
    }
}
