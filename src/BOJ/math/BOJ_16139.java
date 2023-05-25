package BOJ.math;

import java.util.*;
import java.io.*;
public class BOJ_16139 {

    public static void main(String[] args) throws IOException{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[26][input.length() + 1];
            for (int i = 0; i < 26; i++) {
                dp[i][0] = 0;
            }
            String tempChar;
            for (int i = 0; i < input.length(); i++) {
                tempChar = input.charAt(i) + "";
                int asc = tempChar.charAt(0)-97;
                dp[asc][i+1]++;
                for (int j = 0; j < 26; j++) {
                    dp[j][i+1]+=dp[j][i];
                }
            }
            int[] interval = new int[2];
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++) {
                StringTokenizer st=new StringTokenizer(br.readLine());
                tempChar = st.nextToken();
                int asc = tempChar.charAt(0)-97;
                interval[0] = Integer.parseInt(st.nextToken());
                interval[1] = Integer.parseInt(st.nextToken());
                output.append(dp[asc][interval[1]+1] - dp[asc][interval[0]] + "\n");
            }
            System.out.println(output);
        }
    }
