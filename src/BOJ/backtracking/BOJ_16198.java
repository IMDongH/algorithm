package BOJ.backtracking;

import java.util.*;
import java.io.*;

public class BOJ_16198 {

    static int n,max=0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> ball  = new ArrayList<>();

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        String[] list = br.readLine().split(" ");
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            ball.add(Integer.parseInt(list[i]));
        }

        solve(1,0);
        System.out.println(max);
    }

    private static void solve(int idx, int sum) {
        if(n-idx==1){
//            System.out.println(sum + " " + idx);
            max = Math.max(max,sum);
            return;
        }

        for(int i=1; i<n-idx; i++){
            int mul = ball.get(i - 1) * ball.get(i + 1);
//            System.out.println("i : " + i +" mul : "+mul);
            Integer remove = ball.remove(i);
            solve(idx+1,sum+mul);
            ball.add(i,remove);
//            if(!visited[i]){
//                visited[i]=true;
//                ball.
//                System.out.println("i : " + i + " " + ball[i-1]*ball[i+1]);
//
//                visited[i]=false;
//            }
        }
    }

}
