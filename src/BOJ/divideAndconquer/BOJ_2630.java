package BOJ.divideAndconquer;

import java.util.*;
import java.io.*;
public class BOJ_2630 {

    static int blue=0;
    static int white=0;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ar[][];
    static int num;
    public static void main(String args[]) throws IOException{
        num = Integer.parseInt(br.readLine());

        ar = new int[num][num];

        for(int i =0; i<num; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<num; j++){
                ar[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(1,1,num);
        System.out.println(white);
        System.out.println(blue);
    }

    private static int solve(int x, int y, int n) {

        int w = 0, b=0;

        if(n==1){
            return ar[x-1][y-1];
        }else{
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    int r = solve(x+n/2*i,y+n/2*j,n/2);
                    if(r==0){
                        w++;
                    }
                    else if(r==1){
                        b++;
                    }
                }
            }
            if(w==4){
                if(n==num){
                    white++;
                }

                return 0;
            }else if(b==4){
                if(n==num){
                    blue++;
                }
                return 1;
            }else{

                blue =blue + b;
                white = white + w;
                return 2;
            }
        }
    }
}
