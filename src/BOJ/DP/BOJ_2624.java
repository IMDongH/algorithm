package BOJ.DP;

import java.util.*;
import java.io.*;

public class BOJ_2624 {

    static int T, K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Coin> coins = new ArrayList<>();
    static int[] result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine()); //지폐 금액
        K = Integer.parseInt(br.readLine()); //동전 수
        result = new int[T + 1];

        for (int i = 1; i <= K; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            coins.add(new Coin(input[0], input[1]));
        }
        coins.sort((o1, o2) -> o1.price - o2.price);

        result[0] = 1;

        for (Coin coin : coins) {
            int price = coin.price;
            int count = coin.count;
            for (int j = price; j <=T; j++) {
                for (int i = 1; i <= count; i++) {


                    int now = j - price * i;
                    if (now < 0) break;

                    result[j] = result[j] + result[now];
                }
            }


        }

        System.out.println(result[T]);
//        for (int i = 0; i <= T; i++)
//            System.out.println("i = " + i + "  " + result[i]);
    }


    private static class Coin {
        int price;
        int count;

        Coin(int price, int count) {
            this.price = price;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Coin{" +
                    "price=" + price +
                    ", count=" + count +
                    '}';
        }
    }
}