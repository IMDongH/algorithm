package BOJ.bruteforce;

import java.util.*;
import java.io.*;

public class BOJ_1025 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] arr;
    static int n,m,max = -1;

    public static void main(String[] args) throws IOException{
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            str = br.readLine().split("");
            for(int j=0; j<str.length; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                solve(i,j);
            }
        }

        System.out.print(max);
    }

    static void solve(int x, int y){
//        System.out.println("sovle : x: " + x +" y : " +y);
        for(int i=-n; i<n; i++){
            for(int j=-n; j<n; j++){
                if(i==0&&j==0) continue;

                int sum = 0;
                int nx =x;
                int ny =y;
                while(!(nx<0||ny<0||nx>=n||ny>=m)){ //밖으로 나가는 경우 끝
                    sum = sum*10 + arr[nx][ny];
                    nx=nx+i;
                    ny=ny+j;
                    double sqrt = Math.sqrt(sum);

                    if(Math.pow((int)sqrt,2)==sum){
                        if(max<sum){
                            max = sum;
                        }
                    }
//                    System.out.println("nx : " + nx + " ny : " + ny);
                }

            }
        }
    }
}
