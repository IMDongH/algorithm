package BOJ.school.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class lab2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int a=0; a<t; a++){
            Set<Integer> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                set.add(Integer.parseInt(st.nextToken()));

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)
                sb.append(set.contains(Integer.parseInt(st.nextToken()))? 1 : 0).append("\n");

            System.out.print(sb);
        }
    }
}