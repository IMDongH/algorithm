package BOJ.DP;

import java.util.*;
import java.io.*;

public class BOJ_12865 {

        static int n,k;
        static List<Bag> bags = new ArrayList<>();
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static int[] result;
        public static void main(String[] args)throws IOException{
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]); //물품 수
            k = Integer.parseInt(str[1]); //견딜 수 있는 무게
            result = new int[k+1];

            for(int i=0; i<n; i++){
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                bags.add(new Bag(input[0],input[1]));
            }
            bags.sort((o1, o2) -> o2.getWeight() - o1.getWeight());


            for (Bag bag : bags) {
                int weight = bag.getWeight();
                int value = bag.getValue();

                for(int i=k; i>0; i--){
                    if(i<weight){
                        continue;
                    }

                    result[i] = Math.max(result[i-weight]+value,result[i]);
                }
            }

//            for (int i : result) {
//                System.out.println("i = " + i);
//            }
            System.out.println(result[k]);
        }

        static class Bag{
            private int weight;
            private int value;

            public int getWeight() {
                return weight;
            }

            public int getValue() {
                return value;
            }

            public Bag(int weight, int value){
                this.weight = weight;
                this.value = value;
            }


        }
}
