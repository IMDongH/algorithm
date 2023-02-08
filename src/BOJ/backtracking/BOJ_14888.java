package BOJ.backtracking;

import java.util.*;
import java.io.*;

public class BOJ_14888 {

    static StringBuilder sb = new StringBuilder();
    static int[] num;
    static int[] op = new int[4];

    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());

        }

        find(num[0],1);
        System.out.println(MAX);
        System.out.println(MIN);
    }


    public static void find(int number,int idx) {
        if (idx == n) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (op[i] > 0) {

                // 해당 연산자를 1 감소시킨다.
                op[i]--;

                switch (i) {

                    case 0:	find(number + num[idx], idx + 1);	break;
                    case 1:	find(number - num[idx], idx + 1);	break;
                    case 2:	find(number * num[idx], idx + 1);	break;
                    case 3:	find(number / num[idx], idx + 1);	break;

                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                op[i]++;
            }
        }}
}