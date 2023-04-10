package BOJ.graph;

import java.util.*;
import java.io.*;

public class BOJ_1012 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int caseN;
    static int x,y,n,num;
    static StringTokenizer st;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{

        caseN = Integer.parseInt(br.readLine());

        for(int i=0; i<caseN; i++){
            num = 0;
            st = new StringTokenizer(br.readLine()," ");
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            visited = new boolean[x][y];

            for(int j=0; j<x; j++) {
                Arrays.fill(visited[j], false);
            }

            arr = new int[x][y];

            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine()," ");
                int ny = Integer.parseInt(st.nextToken());
                int nx = Integer.parseInt(st.nextToken());

                arr[nx][ny]=1;
            }


            for(int a=0; a<x; a++){
                for(int b=0; b<y; b++){
                    if((!visited[a][b])&&arr[a][b]==1){
                        num++;
                        bfs(a,b);
                    }
                }
            }
            System.out.println(num);
        }

    }

    static private void bfs(int mx,int my){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{mx,my});
        visited[mx][my] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if(!(nx<0||ny<0||nx>=x||ny>=y)){
                    if(!visited[nx][ny]&&arr[nx][ny]==1){
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny]=true;
                    }
                }
            }
        }
    }
}
