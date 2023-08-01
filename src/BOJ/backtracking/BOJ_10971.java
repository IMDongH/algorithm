    package BOJ.backtracking;

    import java.util.*;
    import java.io.*;

    public class BOJ_10971 {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static int n;
        static int[][] arr;
        static StringTokenizer st;
        static boolean visited[];
        static long min = Integer.MAX_VALUE;
        static long sum =0;

        static int[] record;
        public static void main(String[] args) throws IOException{

             n = Integer.parseInt(br.readLine());
             arr=  new int[n+1][n+1];
             record = new int[n+1];
             visited = new boolean[n+1];

             for(int i=1; i<=n; i++){
                 st = new StringTokenizer(br.readLine());
                 for(int j=1; j<=n; j++){
                     arr[i][j] = Integer.parseInt(st.nextToken());
                 }
             }
            nm(0,0);
            System.out.println(min);
        }

        public static void nm(int index,int prev){

            if(index == n){
                sum = 0;
                if(arr[record[n-1]][record[0]]==0)
                {
                    return;
                }
                for(int i=1; i<n; i++){
                    if(arr[record[i-1]][record[i]]==0){
                        return;
                    }
                    sum = sum + arr[record[i-1]][record[i]];
                }
                min = Math.min(min, sum + arr[record[n-1]][record[0]]);


//                sb.append("\n");
                return;
            }
            for(int i=1; i<=n; i++){
                if(visited[i]) continue;
                if(arr[prev][i]==0&&i!=prev&&prev!=0) return;
                visited[i]=true;
                record[index]=i;
                nm(index+1,i);
                visited[i] = false;
            }
        }
    }
