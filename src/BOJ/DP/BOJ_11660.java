package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_11660 {


    static int N,M;
    static int[][] rSum;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rSum= new int[N+1][N+1];

        for(int i=1; i<=N; i++)
        {
            st= new StringTokenizer(br.readLine()," ");
            for(int j=1; j<=N; j++){
                int num = Integer.parseInt(st.nextToken());
                rSum[i][j] =rSum[i][j-1] + rSum[i-1][j] + num - rSum[i-1][j-1];
            }
        }

//        for (int[] ints : rSum) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
        for(int i=0; i<M; i++){
            List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            solve(list.get(0),list.get(1),list.get(2),list.get(3));
        }
    }

    private static void solve(int x1,int y1, int x2, int y2){
//        System.out.println("x1 : " + x1 + "y1 : " + y1 + "x2 : " + x2 + "y2 : " + y2);
//        System.out.println("rSum[x2][y2] : " + rSum[x2][y2]);
//        System.out.println("rSum[x2][y1-1] : " + rSum[x2][y1-1]);
//        System.out.println("rSum[x1][y2-1] : " + rSum[x1][y2-1]);
//        System.out.println("rSum[x1-1][y1-1] : " + rSum[x1-1][y1-1] );

        System.out.println(rSum[x2][y2] - rSum[x2][y1-1] - rSum[x1-1][y2] + rSum[x1-1][y1-1]);
    }
}
