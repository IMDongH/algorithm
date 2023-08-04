package BOJ.bruteforce;

import java.util.*;
import java.io.*;

public class BOJ_14500 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static boolean[][] visited;
    static int n, m, max = -1;
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                solve(i, j, 1, arr[i][j]);
                visited[i][j] = false;

                //ㅗ 모양 4가지 검사
                others(i, j);
            }
        }
        System.out.println(max);
    }

    private static void others(int i, int j) {


        if (i+2 < n && j+1 < m)
            max = Math.max(max, arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j]);
        if (i+2 < n && j > 0)
            max = Math.max(max, arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j-1]);
        if (i+1 < n && j+2 < m)
            max = Math.max(max, arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1]);
        if (i+1 < n && j+1 < m && j > 0)
            max = Math.max(max, arr[i][j] + arr[i+1][j] + arr[i+1][j-1] + arr[i+1][j+1]);
    }

    private static void solve(int x, int y, int depth, int sum) {
        if (depth >= 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            solve(nx, ny, depth + 1, sum + arr[nx][ny]);
            visited[nx][ny] = false;
        }

    }
}
