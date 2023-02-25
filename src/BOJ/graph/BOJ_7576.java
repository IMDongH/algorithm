package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static int N;
    static int M;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());//가로
        M = Integer.parseInt(st.nextToken());//세로

        graph = new int[M+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");

            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs(){

        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int x = q[0];
            int y = q[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || ny<0|| nx>=M || ny >=N) continue;

                if(graph[nx][ny]==0){
                    graph[nx][ny] = graph[x][y]+1;
                    queue.add(new int[]{nx , ny});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j]==0)
                    return -1;
                if(max < graph[i][j]){
                    max = graph[i][j];
                }
            }
        }

        return max -1;
    }
}
