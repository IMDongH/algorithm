package BOJ.simulation;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_16234 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,l,r, cnt = 0;

    static ArrayList<Position> who = new ArrayList<>();
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean flag=true;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<str.length; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        solve();

        System.out.println(cnt);
    }

    public static void solve(){

        while(true){
            flag=true;
            for(int i=0; i<n; i++){
                Arrays.fill(visited[i],false);
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j])
                        bfs(i, j);
                }
            }
            if(flag){
                break;
            }
            cnt++;
        }

    }

    private static void bfs(int x, int y) {

        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x,y));
        who.add(new Position(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Position position = q.poll();
            x = position.getX();
            y = position.getY();
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0||ny<0||nx>=n||ny>=n){
                    continue;
                }
                if(!visited[nx][ny]&&Math.abs(arr[x][y]-arr[nx][ny])>=l&&Math.abs(arr[x][y]-arr[nx][ny])<=r){
                    flag=false;
                    q.add(new Position(nx,ny));
                    who.add(new Position(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }

        int sum = 0;
        for(int i=0; i< who.size(); i++)
        {
            Position position = who.get(i);
            sum+= arr[position.getX()][position.getY()];
        }
        for(int i=0; i< who.size(); i++)
        {
            Position position = who.get(i);
            arr[position.getX()][position.getY()] = sum/who.size();
        }
        who.removeAll(who);
    }

    private static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
