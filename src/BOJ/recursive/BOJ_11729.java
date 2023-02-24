package BOJ.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;

public class BOJ_11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        hanoi(n,1,3,2);

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void hanoi(int n , int start, int destination, int middle){
        if(n==1){
            sb.append(start + " "+ destination);
            sb.append("\n");
            cnt++;
            return ;
        }
        hanoi(n-1,start, middle,destination);
        sb.append(start + " "+ destination);
        sb.append("\n");
        cnt++;
        hanoi(n-1,middle,destination,start);
    }

}
