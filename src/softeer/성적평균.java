package softeer;

import java.io.*;
import java.util.*;

public class 성적평균 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n,k;
  static int[] score;
  static StringTokenizer st;

  public static void main(String[] args) throws IOException{
    st = new StringTokenizer(br.readLine()," ");
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    score = new int[n];
    st = new StringTokenizer(br.readLine()," ");
    score[0] = Integer.parseInt(st.nextToken());
    for(int i=1; i<n; i++){
      score[i]=score[i-1]+Integer.parseInt(st.nextToken());
    }

    for(int i=0; i<k; i++){
      st = new StringTokenizer(br.readLine()," ");
      int start =Integer.parseInt(st.nextToken());
      int end =Integer.parseInt(st.nextToken());
      System.out.println(String.format("%.2f", solve(start,end)));
    }
  }

  static double solve(int start,int end){
    int s,e;
    e = score[end-1];
    if(start==1) {
      s = 0;
    }
    else{
      s=score[start-2];
    }
    int sum = e-s;
    return (double)sum/(end-start+1);
  }
}

