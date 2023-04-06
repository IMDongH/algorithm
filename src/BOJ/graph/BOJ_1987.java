package BOJ.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1987 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static int[][] map;

    static boolean[] visit = new boolean[26];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);

        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt) {


        if (visit[map[x][y]]) {
            max = Math.max(cnt, max);
            return;
        } else {
            visit[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!(nx < 0 || ny < 0 || nx >= N || ny >= M)) {
                    dfs(nx, ny, cnt + 1);
                }
            }
            visit[map[x][y]] = false;
        }
    }
}

