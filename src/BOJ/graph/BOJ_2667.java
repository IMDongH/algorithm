package BOJ.graph;


import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_2667 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer[]> arr;
    static boolean visited[][];
    static int n;
    static int num=0;
    static int[] resultList = new int[625];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{

        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(visited[i],false);
        }

        for(int i=0; i<n; i++){
            List<Integer> list = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).collect(Collectors.toList());
            arr.add(list.toArray(new Integer[0]));

        }



        // for 1인지 체크 방문했는지 체크
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(arr.get(i)[j]==1&&!visited[i][j]){
                    bfs(i,j);
                }
            }
        }


        System.out.println(num);
        Arrays.sort(resultList);
        for (int i : resultList) {
            if(i!=0)
                System.out.println(i);
        }
    }

    static private void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]  = true;
        resultList[num]++;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (!(nx < 0 || ny < 0 || nx >= n || ny >= n)) {
                    if(arr.get(nx)[ny]==1&&!visited[nx][ny]){
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        resultList[num]++;
                    }


                }
            }
        }
        num++;
    }
}
