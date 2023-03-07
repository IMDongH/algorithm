package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_11725 {

    static ArrayList<ArrayList<Integer>> arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();

        for(int i = 0 ; i<=n; i++){
            arr.add(new ArrayList<Integer>());
        }
        for(int i=0; i<n; i++){
            char[] str = br.readLine().replaceAll(" ", "").toCharArray();

            System.out.println(str[0]);
            arr.get(Integer.parseInt(String.valueOf(str[0]))).add((int) str[1]);

        }

    }
}
