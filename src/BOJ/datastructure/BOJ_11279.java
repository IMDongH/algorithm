package BOJ.datastructure;


import java.util.*;
import java.io.*;

public class BOJ_11279 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num ==0){
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
