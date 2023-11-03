package softeer;


import java.io.*;
import java.util.*;

public class 우물안개구리 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int[] weight;
  static int[] best;
  static int n, m, result = 0;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    weight = new int[n + 1];
    best = new int[n + 1];

    st = new StringTokenizer(br.readLine(), " ");

    for (int i = 1; i <= n; i++) {
      weight[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int userA = Integer.parseInt(st.nextToken());
      int userB = Integer.parseInt(st.nextToken());

      if (weight[userA] <= weight[userB]) {
        best[userA]++;
      }
      if (weight[userA] >= weight[userB]) {
        best[userB]++;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (best[i] == 0) {
        result++;
      }
    }
    System.out.println(result);
  }
}


