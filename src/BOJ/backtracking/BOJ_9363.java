package BOJ.backtracking;

import java.util.*;
import java.io.*;

public class BOJ_9363 {

    static int n;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        nQueen(0);

        System.out.println(cnt);
    }

    public static void nQueen(int index) {
        if (index == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[index] = i;
            //index 번째 열 i번쨰 행에 두기


            if (promising(index)) {//유망한지 판단 후
                nQueen(index + 1);
            }

        }
    }

    private static boolean promising(int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i]==arr[index]||
                    Math.abs(index-i)==Math.abs(arr[index]-arr[i])) {
                return false;
            }
        }

        return true;
    }
}
