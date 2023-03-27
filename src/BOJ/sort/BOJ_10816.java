package BOJ.sort;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_10816 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (Integer integer : list) {
            hm.put(integer ,hm.getOrDefault(integer,0)+1);
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> mList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (Integer integer : mList) {
            sb.append(hm.getOrDefault(integer, 0)).append(' ');
        }

        System.out.println(sb);

    }

}
