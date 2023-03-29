package BOJ.sort;

import java.util.*;
import java.io.*;
public class BOJ_2210 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static int min=Integer.MAX_VALUE;

    static int[] home;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine()," ");
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        home = new int[n];

        for(int i=0; i<n; i++){
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        if(m==2){
            System.out.println(home[n-1]-home[0]);
        }
        else{
            solve(1,home[n-1]-home[0]);
            System.out.println(min);
        }

    }

    private static void solve(int start, int end){

        if(start>end)
        {
            return;
        }

        int mid = (end+start)/2;

        int count=1;
        int locate=home[0];

        for(int i=0; i<n; i++){
            if(home[i]-locate>=mid){
                count++;
                locate=home[i];
            }
        }

        if(m<=count){
            min = mid;
            solve(mid+1,end);
        }else{

            solve(start,mid-1);
        }


    }
}
