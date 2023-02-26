package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static int[][] map;
    static Queue<int []> queue;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        solve(0);
        System.out.println(max);
    }

    private static void solve(int wall){
        if(wall ==3){
            bfs();
            return;
        }
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    solve(wall+1);
                    map[i][j]=0;
                }
            }
        }

    }

    private static void bfs(){

        queue  = new LinkedList<>();
        int copyMap[][] = new int[N][M];
        for(int i=0; i<N; i++){
            copyMap[i] = map[i].clone();
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copyMap[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for(int i =0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx<0||nx>=N||ny<0||ny>=M) continue;

                    if(copyMap[nx][ny] == 0){
                        copyMap[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
            }

        }
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copyMap[i][j]==0){
                    cnt++;
                }
            }
        }
        max = (max < cnt) ? cnt : max;


    }

}
