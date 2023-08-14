package BOJ.implementation;

import java.util.*;
import java.io.*;
public class BOJ_15927 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static int result=-1;

    public static void main(String[] args) throws IOException {

        str = br.readLine();
        String reversedStr = new StringBuilder(str).reverse().toString();

        if (!str.equals(reversedStr)) { // 팰린드롬이 아닌 경우
            result = str.length();
        } else {
            boolean allSame = true;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != str.charAt(i-1)) {
                    allSame = false;
                    break;
                }
            }

            if (!allSame) { // 모든 문자가 같지 않은 경우
                result = str.length() - 1;
            }
        }

        System.out.println(result);
    }
}
