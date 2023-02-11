package BOJ.tree;

import java.io.*;
import java.util.*;

public class BOJ_1068 {

    static List<Integer>[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sb.readLine());
        StringTokenizer st = new StringTokenizer(sb.readLine()," ");
        int[] numbers = new int[n];
        node = new List[n];

        int root = 0;
        for(int i=0; st.hasMoreTokens(); i++){
            node[i] = new ArrayList<>();
            numbers[i]= (Integer.valueOf(st.nextToken()));
        }
        Arrays.sort(numbers);

        for(int i=0; i<n; i++){
            if(i==0){
                root =
            }
            else{

            }
        }

    }
}
