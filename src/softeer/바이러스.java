package softeer;

import java.util.*;
import java.io.*;
public class 바이러스 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static final int div = 1000000007;
  static long  k,p,n;
  static StringTokenizer st;
  public static void main(String[] args) throws IOException{
    st = new StringTokenizer(br.readLine()," ");
    k =Integer.parseInt(st.nextToken());
    p =Integer.parseInt(st.nextToken());
    n =Integer.parseInt(st.nextToken());

    System.out.println(k%div*solve(p,n)%div);
  }

  static long  solve(long n, long k){

    if(k==1) return n;
    long a = solve(n,k/2)%div;

    if(k%2==1){
      return (a%div*a%div)*n%div;
    }else{
      return (a%div*a%div)%div;
    }
  }
}
