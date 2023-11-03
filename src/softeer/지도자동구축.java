  package softeer;

  import java.io.*;
  import java.util.*;

  public class 지도자동구축 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

      n = Integer.parseInt(br.readLine());
      arr = new int[n + 1];
      arr[0] = 2;

      for (int i = 1; i <= n; i++) {
        arr[i] = arr[i - 1] * 2 - 1;
      }

      System.out.println(arr[n] * arr[n]);
    }
  }

