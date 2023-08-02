package BOJ.greedy;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_1931 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(arr,(o1,o2) -> o2[1]-o1[1]==0 ? o1[0]-o2[0]: o1[1]-o2[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][0]);
        int prevEnd = arr[0][1];
        int count=0;
        for(int i=1; i<n; i++){
            if(prevEnd<=arr[i][0]){
                prevEnd = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }

}
