package BOJ.datastructure;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BOJ_1021 {

    static int count=0;
    static LinkedList<Integer> deque = new LinkedList<>();
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i =1; i<=n; i++)
            deque.add(i);

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (Integer integer : list) {
            solve(integer);
        }
        System.out.println(count);
    }

    static void solve(Integer n) {
        int target_idx = deque.indexOf(n);
        int half_idx;
        if(deque.size() % 2 == 0) {
            half_idx = deque.size() / 2 - 1;
        }
        else {
            half_idx = deque.size() / 2;
        }


        if(target_idx <= half_idx) {
            for(int j = 0; j < target_idx; j++) {
                int temp = deque.pollFirst();
                deque.offerLast(temp);
                count++;
            }
        }
        else {
            for(int j = 0; j < deque.size() - target_idx; j++) {
                int temp = deque.pollLast();
                deque.offerFirst(temp);
                count++;
            }

        }
        deque.pollFirst();
    }

}
