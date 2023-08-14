package BOJ.implementation;

import java.util.*;
import java.io.*;

public class BOJ_20437 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, t;
    static String str;
    static List<Integer>[] arr = new List[26];

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine()); //게임 수

        while (t > 0) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            str = br.readLine();
            n = Integer.parseInt(br.readLine()); //문자 수

            for (int i = 0; i < 26; i++) {
                arr[i] = new ArrayList<>();
            }


            str = str.toUpperCase();
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 65].add(j);
                if(arr[str.charAt(j)-65].size()==n){
                    int idx = str.charAt(j) - 65;
                    min = Math.min(arr[idx].get(n-1)-arr[idx].get(0),min);
                    max = Math.max(arr[idx].get(n-1)-arr[idx].get(0),max);
                    arr[idx].remove(0);
                }
            }


//            for (int i = 0; i < 26; i++) {
//                if (arr[i].size() >= n) {
//                    for (int j = 0; j < arr[i].size() - 1; j++) {
//                        min = Math.min(arr[i].get(j + 1) - arr[i].get(j), min);
//                    }
//                    max = Math.max(arr[i].get(arr[i].size() - 1) - arr[i].get(0), max);
//                }
//            }
            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println((min+1) + " " + (max+1));
            }


            t--;
        }

    }
}
