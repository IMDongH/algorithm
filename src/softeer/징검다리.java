package softeer;

import java.util.*;
import java.io.*;

public class 징검다리 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] arr;
  static StringTokenizer st;
  static int result=0,max=0;
  public static void main(String[] args) throws IOException{
     n = Integer.parseInt(br.readLine());
     arr = new int[n];

    st = new StringTokenizer(br.readLine()," ");
    for(int i=0; i<n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int now = 0;
    for(int i=1; i<n; i++){
      if(arr[now]<arr[i]){
        result++;
        now++;
      }
    }
    System.out.println(result+1);
  }
}
