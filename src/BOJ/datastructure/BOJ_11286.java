package BOJ.datastructure;

import java.util.*;
import java.io.*;

public class BOJ_11286 {


    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1)>Math.abs(o2)){
                return 1;
            }
            else if(Math.abs(o1)==Math.abs(o2)){
                if(o1>o2){
                    return 1;
                }
                else if(o1<o2){
                    return -1;
                }
                else{
                    return 0;
                }
            }
            else{
                return -1;
            }
        }

    });
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num==0){
                if(pq.isEmpty()){
                    System.out.println("0");
                }
                else{
                    System.out.println(pq.poll());
                }
            }
            else{
                pq.add(num);
            }
        }
    }
}
