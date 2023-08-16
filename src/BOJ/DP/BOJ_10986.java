package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10986 {

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

            prefixSum[i] = (prefixSum[i - 1] + num)%K; //구간 합 구하기

//            System.out.println(i + " " + prefixSum[i] + " " + counts.getOrDefault(K-prefixSum[i],0L));
//            if(prefixSum[i]==0){
//                result += counts.getOrDefault(0, 0L);
//            }else{
//
//            }
            result += counts.getOrDefault(prefixSum[i], 0L); // ex) 5 - 3(5로 나누었을떄 나머지) = 나머지가 2인 값의 수를 더해준다.
            counts.put(prefixSum[i], counts.getOrDefault(prefixSum[i], 0L) + 1);
        }
        System.out.println(result);
    }
}
