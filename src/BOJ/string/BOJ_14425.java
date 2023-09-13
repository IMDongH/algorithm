package BOJ.string;

import java.util.*;
import java.io.*;

public class BOJ_14425 {

    static int n,m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Character,List<String>> map = new HashMap<>();
    static int result=0;
    public static void main(String[] args) throws IOException{

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];

        for(int i=0; i<n; i++){
            String input = br.readLine();
            char firstChar = input.charAt(0);
            List<String> list = map.getOrDefault(firstChar, new ArrayList<>());
            list.add(input);
            map.put(firstChar,list);
        }

        for(int i=0; i<m; i++){
            String input = br.readLine();
            char firstChar = input.charAt(0);
            List<String> list = map.getOrDefault(firstChar, new ArrayList<>());
            if(list.contains(input)){
                result++;
            }
        }

        System.out.println(result);
    }
}
