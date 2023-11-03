package softeer;
import java.io.*;
import java.util.*;

public class 택배마스터 {
  static int n,m,k;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int[] arr;
  static boolean[] visited;
  static StringTokenizer st;
  static int[] matrix;
  static int result=Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException{
    st = new StringTokenizer(br.readLine()," ");
    n = Integer.parseInt(st.nextToken()); //레일 수
    m = Integer.parseInt(st.nextToken()); //최대 택배크기
    k = Integer.parseInt(st.nextToken()); //일의 수

    matrix = new int[n];
    arr = new int[n];
    visited = new boolean[n];
    st = new StringTokenizer(br.readLine()," ");
    for(int i=0; i<n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    dfs(0);

    System.out.println(result);
  }

  static void dfs(int idx){
    if(idx==n){//매트릭스가 모두 찬 경우
      solve();
      return;
    }

    for(int i=0; i<n; i++){
      if(visited[i]) continue;
      visited[i] = true;
      matrix[idx]=arr[i];
      dfs(idx+1);
      visited[i] = false;
    }
  }

  static void solve(){
    int work=0;
    int bucket = 0;
    int sum = 0;
    int i=0;
    while(work<k){
      bucket=0;
      while(bucket+matrix[i]<=m)
      {

        bucket = bucket + matrix[i];
        i=(i+1)%n;

      }
      sum=sum+bucket;
      work++;
    }
    result = Math.min(result,sum);
  }
}
