package BOJ.backtracking;

import java.awt.image.BufferedImageFilter;
import java.util.*;
import java.io.*;

public class BOJ_14889 {

    static int n;
    static int[][] ab;
    static int[] num;

    static int MIN = Integer.MAX_VALUE;
    static boolean visited[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ab = new int[n][n];
        visited = new boolean[n + 1];
        num = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                ab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
        System.out.println(MIN);
    }

    private static void solve(int index, int cnt) {
        if (cnt == n / 2) {

            makeDiff();
            return;
        }

        for (int i = index; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            solve(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    private static void makeDiff() {
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    num1 = num1 + ab[i][j] + ab[j][i];
                } else if ((!visited[i] && !visited[j])) {
                    num2 = num2 + ab[i][j] + ab[j][i];
                }
            }
        }

        MIN = Math.min(MIN, Math.abs(num1 - num2));
    }

}
