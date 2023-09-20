    package BOJ.DP;

    import java.util.*;
    import java.io.*;
    public class BOJ_5557 {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static int n,result;

        static int[] input;
        static long[][] dp = new long[101][21];

        public static void main(String[] args) throws IOException{
            n = Integer.parseInt(br.readLine());
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            result = input[n-1];
            input[n-1] = 0;

            dp[1][input[0]]=1;

            for(int i=2; i<n; i++){
                for(int j=0; j<21; j++){

                    int minus = j - input[i-1];
                    int plus = j + input[i-1];

                    if(plus<=20) {
                        dp[i][plus] = dp[i][plus] + dp[i-1][j];
                    }

                    if(minus>=0) {
                        dp[i][minus] = dp[i][minus] + dp[i-1][j];
                    }

                }
            }


            System.out.println(dp[n-1][result]);
        }
    }
