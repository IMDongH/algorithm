package softeer;


import java.io.*;
import java.util.*;

public class 성적평가 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] arr;
  static int[] rank;
  static int[] sum;
  static StringTokenizer st;
  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws IOException {

    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    rank = new int[n];
    sum = new int[n];

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++) {
        int score = Integer.parseInt(st.nextToken());
        arr[j] = score;
        sum[j] = sum[j] + score;
      }

      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (j == k) {
            continue;
          }

          if (arr[j] < arr[k]) {
            rank[j]++;
          }
        }
      }
      for (int j = 0; j < n; j++) {
        sb.append(rank[j] + 1);
        if (j != n - 1) {
          sb.append(" ");
        }
        rank[j] = 0;
      }
      sb.append("\n");
    }

    for (int j = 0; j < n; j++) {
      for (int k = 0; k < n; k++) {
        if (j == k) {
          continue;
        }

        if (sum[j] < sum[k]) {
          rank[j]++;
        }
      }
    }
    for (int j = 0; j < n; j++) {
      sb.append(rank[j] + 1);
      if (j != n - 1) {
        sb.append(" ");
      }
    }

    System.out.println(sb);
    List<Integer> test = new ArrayList<>();
    test.sort((o1,o2)-> o1-o2 );
}

}
