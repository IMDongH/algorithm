package BOJ.math;

import java.io.*;
import java.util.*;

public class BOJ_1990 {
    public static boolean[] isPrime = new boolean[100_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        eratosthenes();

        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (!isPrime[i] && isPalindrome(i)) {
                sb.append(i).append("\n");
            }
        }
        sb.append(-1);

        System.out.println(sb);
    }

    public static boolean isPalindrome(int n) {
        String t = String.valueOf(n);

        for (int i = 0; i < t.length() / 2; i++) {
            if (t.charAt(i) != t.charAt(t.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void eratosthenes() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= 100_000_000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= 100_000_000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }
}