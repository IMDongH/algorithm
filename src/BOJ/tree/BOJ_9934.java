package BOJ.tree;

import java.util.*;
import java.io.*;

public class BOJ_9934 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] arr;
    static List<Integer>[] list;
    static String[] str ;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr= new int[n+1];
        str = br.readLine().split(" ");
        list = new List[n];

        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        solve(0,str.length,0); // n==3 -> left - 1 right 7 - middle 4

        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


    static void solve(int left, int right, int depth){


        int middle = (left + right) / 2;
        list[depth].add(Integer.parseInt(str[middle]));
//        System.out.print(str[middle]);
        if(depth==n-1){
            return;
        }
        solve(left,middle-1,depth+1);
        solve(middle+1,right,depth+1);
    }
}
