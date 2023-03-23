package BOJ.datastructure;


import java.util.*;
import java.io.*;

public class BOJ_11279 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer> arr = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(br.readLine());
//            System.out.println("index = " + index + " " +  arr.size() + " " + '\n' );
            if (index == 0) {
                if (!arr.isEmpty()) {
                    Integer remove = arr.pollFirst();
//                    System.out.println("remove " + remove + "\n");
                    sb.append(remove);
                    sb.append("\n");
                } else {
//                    System.out.println("remove " + "\n");
                    sb.append(0);
                    sb.append("\n");
                }
            } else {
                if (!arr.isEmpty()) {
                    boolean flag = false;
                    int j = 0;
                    for (Integer integer : arr) {
                        if (integer <= index) {
                            arr.add(j, index);
                            flag = true;
                            break;
                        }
                        j++;
                    }
                    if(!flag)
                    arr.add(j, index);

                } else {
                    arr.add(index);
                }
            }
        }
        System.out.println(sb);

    }
}
