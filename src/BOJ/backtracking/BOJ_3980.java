package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3980 {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] player = new int[12][12];
    static int n;
    static int max = 0;
    static boolean[] visited = new boolean[12];
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 11; j++) {
                    player[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = 0;
            solve(0, 0);
            System.out.println(max);
        }
    }

    public static void solve(int index, int sum) {
        if (index == 11) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if(player[index][i]==0) continue;
            if(visited[i]) continue;
            visited[i] = true;
            sum+=player[index][i];
            solve(index+1,sum);
            visited[i] = false ;
            sum-=player[index][i];
        }
    }
}
