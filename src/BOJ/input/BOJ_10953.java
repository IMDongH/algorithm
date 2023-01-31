package BOJ.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_10953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        for(int i=0; i<count; i++){
            List<Integer> list = Arrays.stream(br.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());

            int sum = 0;
            for(Integer num : list){
                sum = sum+num;
            }
            sb.append(sum);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
