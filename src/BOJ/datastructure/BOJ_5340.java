package BOJ.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_5340 {

    static Deque<Integer> deque = new LinkedList<Integer>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            boolean error = false;
            sb = new StringBuilder();
            String[] str = br.readLine().split("");
            int num = Integer.parseInt(br.readLine());

            String arrStr = br.readLine();
            for (String s : arrStr.substring(1, arrStr.length() - 1).split(","))
                if (!s.equals(""))
                    deque.add(Integer.valueOf(s));

            boolean reverse = false;
            for (int k = 0; k < str.length; k++) {
                if (str[k].equals("R")) {
                    reverse = !reverse;
                } else {

                    if (deque.isEmpty()) {
                        System.out.println("error");
                        error = true;
                        break;
                    } else {
                        if (reverse) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }

                }
            }
            if (!error) {
                StringBuilder sb = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    sb.append(reverse ? deque.removeLast() : deque.removeFirst());
                    if (deque.size() != 0)
                        sb.append(',');
                }
                sb.append(']');
                System.out.println(sb);
            }
        }

    }

}
