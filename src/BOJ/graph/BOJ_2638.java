package BOJ.graph;

import java.util.*;
import java.io.*;

public class BOJ_2638 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int n, m, time = 0;
  static int[][] arr;
  static int[][] count;
  static boolean[][] visited;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    count = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());

      }
    }

    while (true) {
      if (bfs()) {
        break;
      }
      for (int i = 0; i < n; i++) {
        Arrays.fill(visited[i], false);
        Arrays.fill(count[i], 0);
      }
    }

    System.out.println(time-1);


  }

  public static boolean bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    visited[0][0] = true;
    time++;
    int cnt = 0;

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = poll[0] + dx[i];
        int ny = poll[1] + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
          continue;
        }

        if (arr[nx][ny] == 1) {
          cnt++;
          count[nx][ny]++;
          if (count[nx][ny] == 2) {
            arr[nx][ny] = 0;
            visited[nx][ny] = true;

          }
          continue;
        } else {
          queue.add(new int[]{nx, ny});
        }
        visited[nx][ny] = true;
      }
    }

    if (cnt == 0) {
      return true;
    }

    return false;
  }
}
