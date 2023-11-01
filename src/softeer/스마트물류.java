package softeer;

import java.util.*;
import java.io.*;

public class 스마트물류 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, k, result = 0;
  static StringTokenizer st;

  static String[] input;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());

    k = Integer.parseInt(st.nextToken());

    input = br.readLine().split("");

    for (int i = 0; i < n; i++) {
      if (input[i].equals("P")) {
        for (int j = i - k; j <= i + k; j++) {
          if (j < 0 || j >= n) {
            continue;
          }
          if (input[j].equals("H")) {
            input[j] = "N";
            result++;
            break;
          }
        }
      }
    }
    System.out.println(result);
  }
}
