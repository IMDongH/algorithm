package BOJ.sort;

import java.util.*;
import java.io.*;
public class BOJ_11650 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String ar[][];
    public static void main(String args[]) throws IOException{
        int n = Integer.parseInt(br.readLine());

        ar = new String[n][2];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            ar[i][0] = str[0];
            ar[i][1] = str[1];
        }
        solve();
        for (String[] strings : ar) {
            sb.append(strings[0] + " " + strings[1]+"\n");
        }

        System.out.println(sb);
    }

    private static void solve() {

        Arrays.sort(ar, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int n = Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                if(Integer.parseInt(o1[0]) - Integer.parseInt(o2[0])==0){
                     return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }else{
                    return n;
                }

            }


        });
    }
}
