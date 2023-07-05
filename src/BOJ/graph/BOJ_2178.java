package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    static class Pos{
            int r,c,dist;

        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int[][] maze;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static boolean visited[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];


        for(int i=0; i<n; i++){
            String str = br.readLine();

            for(int j=0; j<m; j++)
                maze[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
        }

        bfs(0);
    }

    private static void bfs(int startN) {

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(startN,startN,0));

        while(!queue.isEmpty()){
            Pos pos = queue.poll();

            for(int i=0; i<4; i++)
            {
                int nX = pos.r + dx[i];
                int nY = pos.c + dy[i];
                int nD = pos.dist+1;

                if(nX<0 || nY<0||nX>=n || nY>=m||visited[nX][nY]==true||maze[nX][nY]==0){
                    continue;
                }
                if(nX == n-1 && nY==m-1){
                    System.out.println(nD+1);
                    return;
                }
                queue.add(new Pos(nX,nY,nD));
                visited[nX][nY]=true;

            }
        }
    }
}
