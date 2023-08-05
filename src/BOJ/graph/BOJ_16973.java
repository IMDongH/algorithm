package BOJ.graph;

import java.util.*;
import java.io.*;

public class BOJ_16973 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, sR, sC, dR, dC, sSR, sSC, result = -1;
    static int[][] arr;
    static boolean[][] visited;
    static StringTokenizer st;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static List<Pos> wall = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    arr[i][j] = -1;
                    wall.add(new Pos(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        sSR = Integer.parseInt(st.nextToken()); //사각형 세로
        sSC = Integer.parseInt(st.nextToken()); //사각형 가로
        sR = Integer.parseInt(st.nextToken()); //시작 지점 row
        sC = Integer.parseInt(st.nextToken()); //시작 지점 column
        dR = Integer.parseInt(st.nextToken()); //도착 지점 row
        dC = Integer.parseInt(st.nextToken()); //도착 지점 column
        visited[sR][sC] = true;
        queue.add(new int[]{sR, sC});

        bfs();
//         result = (BOJ_16973.result == 0) ? -1 : BOJ_16973.result;
        System.out.println(result);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x == dR && y == dC) {
                result = arr[x][y];
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
//            System.out.println("continue nx : " + nx + " ny : " + ny + " " + (nx + sSR) + " " + (ny + sSC));
                if (nx < 1 || ny < 1 || (nx + sSR) > n + 1 || (ny + sSC) > m + 1 || visited[nx][ny] || arr[nx][ny] != 0)
                    continue; // 직사각형이 범위를 벗어나는 경우

                if (!isPossible(nx, ny)) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                arr[nx][ny] = arr[x][y] + 1;
            }
        }
    }

//    private static void dfs(int x, int y, int cnt) { //시간 초과
//
//        if (x == dR && y == dC) {
//            result = cnt;
//        }
//
//        for (int k = 0; k < 4; k++) {
//            int nx = x + dx[k];
//            int ny = y + dy[k];
////            System.out.println("continue nx : " + nx + " ny : " + ny + " " + (nx + sSR) + " " + (ny + sSC));
//            if (nx < 1 || ny < 1 || (nx + sSR) > n+1 || (ny + sSC) > m+1 || visited[nx][ny] || arr[nx][ny]==1) continue; // 직사각형이 범위를 벗어나는 경우
////            System.out.println("nx : " + nx + " ny : " + ny + " " + (nx + sSR) + " " + (ny + sSC));
//
//
//
//            if (isPossible(nx,ny)) {
//                        visited[nx][ny] = true;
//                        dfs(nx, ny, cnt + 1);
//                        visited[nx][ny] = false;
//            }
//
//        }
//    }

    private static boolean isPossible(int x, int y) {

        for (int i = 0; i < wall.size(); i++) {
            Pos p = wall.get(i);

            int px = p.x;
            int py = p.y;

            if (px >= x && px <= x + sSR - 1 && py >= y && py <= y + sSC - 1) {
                return false;
            }

        }
        return true;
    }


    private static class Pos {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
