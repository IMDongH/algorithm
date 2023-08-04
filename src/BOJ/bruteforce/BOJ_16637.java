    package BOJ.bruteforce;

    import java.util.*;
    import java.io.*;

    public class BOJ_16637 {
        static int n,max=Integer.MIN_VALUE;
        static String[] list;
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        public static void main(String[] args) throws IOException{
            n = Integer.parseInt(br.readLine());

            list = br.readLine().split("");

            dfs(0,0);

            System.out.println(max);
        }

        private static void dfs(int idx, int sum) {
            if(idx>=n) {
                max = Math.max(max,sum);
                return;
            }

            String operation = idx == 0 ? "+" : list[idx-1];


            if(idx+2<n){
                dfs(idx+4,calculation(sum,calculation(Integer.parseInt(list[idx]),Integer.parseInt(list[idx+2]),list[idx+1]),operation));
            }

            dfs(idx+2,calculation(sum,Integer.parseInt(list[idx]),operation));
        }

        private static int calculation(int a,int b,String op){

            if(op.equals("+")){
                a = a + b;

            }
            if(op.equals("-")){
                a = a - b;
            }
            if(op.equals("*")){
                a = a * b;
            }
            return a;
        }
    }
