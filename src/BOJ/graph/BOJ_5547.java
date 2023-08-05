package BOJ.graph;

import java.util.*;
import java.io.*;
public class BOJ_5547 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,m,result=0;
    static int[][] arr;
    static boolean[][] visited;
    static StringTokenizer st;

    static int[][] even = {{-1,-1},{0,-1},{1,0},{0,1},{-1,1},{-1,0}};
    static int[][] odd = {{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,0}};

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr= new int[n+2][m+2];
        visited = new boolean[n+2][m+2];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<=m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        bfs();
//        while (true){
//            if(){
//                break;
//            }
//            for (boolean[] booleans : visited) {
//                Arrays.fill(booleans,false);
//            }
//        }
        System.out.println(result);
    }

    private static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        int cnt=0;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for(int k=0; k<6; k++) {
                int nx;
                int ny;
//                System.out.println("test : " + x + " " + y);
                if (x % 2 == 0) { //짝수
                    nx = x + even[k][1];
                    ny = y + even[k][0];
                } else { //홀수
                    nx = x + odd[k][1];
                    ny = y + odd[k][0];
                }
//                System.out.println(nx + " " + ny);
                if (nx < 0 || ny < 0 || nx > n + 1 || ny > m + 1 || visited[nx][ny]) continue;

                if(arr[nx][ny]==1){
//                    System.out.println(ny + " " + nx);
//                    arr[nx][ny]=0;
                    cnt++;
                }
                else{
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny]=true;
                }

            }
        }
        if(cnt==0){
            return true;
        }else{
            result=result+cnt;
            return false;
        }

    }
}
