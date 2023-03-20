package BOJ.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10828 {


    static ArrayList<Integer> stk = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            stack(str);
        }

    }

    static void stack(String str) {
        st = new StringTokenizer(str, " ");
        String order = st.nextToken();
        if (order.contains("push")) {
            stk.add(Integer.valueOf(st.nextToken()));
        } else if (order.contains("top")) {
            if (stk.size() == 0) {
                System.out.println("-1");
            } else {
                System.out.println(stk.get(stk.size() - 1));
            }
        } else if (order.contains("size")) {
            System.out.println(stk.size());
        } else if (order.contains("empty")) {
            if (stk.size() == 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        } else if (order.contains("pop")) {
            if (stk.size() == 0) {
                System.out.println("-1");
            } else {
                System.out.println(stk.get(stk.size() - 1));
                stk.remove(stk.size() - 1);
            }
        }
    }

}
