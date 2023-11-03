package softeer;

import java.io.*;
import java.util.*;

public class 장애물인식프로그램 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static List<Integer> result = new ArrayList<>();
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = new int[]{0, 0, 1, -1};
  static int[] dy = new int[]{1, -1, 0, 0};

  public static void main(String[] args) throws IOException {

    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(input[j]);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && arr[i][j] == 1) {
          result.add(bfs(i, j));
        }
      }
    }
    System.out.println(result.size());
    result.sort((o1, o2) -> o1 - o2);
    for (Integer i : result) {
      System.out.println(i + 1);
    }
  }

  static int bfs(int a, int b) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{a, b});
    visited[a][b] = true;
    int cnt = 0;
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) {
          continue;
        }

        if (arr[nx][ny] == 1) {
          visited[nx][ny] = true;
          cnt++;
          queue.add(new int[]{nx, ny});
        }
      }
    }
    return cnt;
  }
}

