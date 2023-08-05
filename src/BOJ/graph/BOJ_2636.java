package BOJ.graph;

import java.util.*;
import java.io.*;

public class BOJ_2636 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m,result=0,time=0;
    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());//가로
        m = Integer.parseInt(st.nextToken());//세로

        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        while(true){
            if(bfs())
                break;
            for (boolean[] booleans : visited) {
                Arrays.fill(booleans,false);
            }
        }
        System.out.println(time-1);
        System.out.println(result);
    }

    private static boolean bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        time++;
        int cnt = 0;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]) continue;

                if(arr[nx][ny]==1){
                    cnt++;
                    arr[nx][ny]=0;
                }else{
                    queue.add(new int[]{nx,ny});
                }
                visited[nx][ny]=true;
            }
        }

        if(cnt==0){

            return true;
        }else{
            result = cnt;
            return false;
        }

    }
}
