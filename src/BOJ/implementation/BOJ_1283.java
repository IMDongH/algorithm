package BOJ.implementation;

import java.io.*;
import java.util.*;

public class BOJ_1283 {

    static Map<String, String> keySet = new HashMap<>();
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String originalS = br.readLine();
            solve(originalS);

        }
        System.out.print(result);
    }


    //문장을 " " 별로 split 하며 String[] 를 구함
    //이 각각의 단어들을 char[] 로 바꿔 확인
    private static void solve(String originalS) {

        String[] words = originalS.split(" ");

        for (int i = 0; i < words.length; i++) { //각각의 단어마다

            String key = words[i].substring(0, 1).toUpperCase();

            if (keySet.get(key) == null) //map 에 존재하지 않는 경우 - key 로 등록 가능
            {
                keySet.put(key, words[i]);
                sb = new StringBuilder(words[i]);
                sb.insert(0, '[').insert(2, ']');
                words[i] = sb.toString();
                print(words);
                return;
            }
        }

        //여기 까지 온 경우 첫 글자에 없는 경우임 - 모든 글자 탐색하며 확인
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String key = String.valueOf(words[i].charAt(j)).toUpperCase();
                if (keySet.get(key) == null) //map 에 존재하지 않는 경우 - key 로 등록 가능
                {
                    keySet.put(key, words[i]);
                    sb = new StringBuilder(words[i]);
                    sb.insert(j, '[').insert(j+2, ']');
                    words[i] = sb.toString();
                    print(words);
                    return;
                }
            }
        }

        //어떤 글자도 불가능 한 경우
        result.append(originalS).append("\n");
    }

    private static void print(String[] words) {
        for (String word : words) {
            result.append(word).append(" ");
        }
        result.append('\n');
    }
}
