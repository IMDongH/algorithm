package BOJ.backtracking;

import java.util.*;
import java.io.*;
public class BOJ_6443 {

    static int n, length=0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[] arr;
    static boolean[] visited;
    static Stack<Character> result;
    static int[] check;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            arr = br.readLine().toCharArray();

            Arrays.sort(arr);
            length = arr.length;
            check = new int[26];
            result=new Stack<>();
            for(char now: arr){
                check[now-'a']++;
            }
            visited = new boolean[length];
            solve();

        }
        ans.forEach(System.out::println);


    }

    private static void solve(){
        if(result.size()==length){
            sb = new StringBuilder();
            for (Character character : result) {
                sb.append(character);
            }
//            for(int i=0; i< length; i++){
//                sb.append(result.peek());
//            }
            ans.add(sb.toString());
        }


        for(int i=0; i<26; i++){
            if(check[i]>0){
                check[i]--;
                result.push((char) (i+'a'));
                solve();
                result.pop();
                check[i]++;
            }
        }

    }

}
