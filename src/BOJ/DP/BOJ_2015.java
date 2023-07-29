package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2015 {

    static int N, K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Long result = 0L;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N + 1];

        Map<Integer, Long> counts = new HashMap<>();

        counts.put(0, 1L);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());

            prefixSum[i] = prefixSum[i - 1] + num;

            result += counts.getOrDefault(prefixSum[i] - K, 0L);

            counts.put(prefixSum[i], counts.getOrDefault(prefixSum[i], 0L) + 1);
        }
        System.out.println(result);
    }
}
