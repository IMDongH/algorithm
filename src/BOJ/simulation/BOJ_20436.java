package BOJ.simulation;

import java.io.*;
import java.util.*;

public class BOJ_20436 {

    private static class xy {
        int x;
        int y;

        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Map<Character, xy> s = new HashMap<>();
    static Map<Character, xy> v = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        xy L, R;
        int time = 0;
        Character c;
        addMap();

        L = s.get(input.charAt(0));
        R = v.get(input.charAt(2));

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (s.containsKey(c)) {
                xy dir_L = s.get(c);
                time += Math.abs(L.x - dir_L.x) + Math.abs(L.y - dir_L.y) + 1;
                L = dir_L;
            } else if (v.containsKey(c)) {
                xy dir_R = v.get(c);
                time += Math.abs(R.x - dir_R.x) + Math.abs(R.y - dir_R.y) + 1;
                R = dir_R;
            }
        }

        System.out.println(time);

    }

    private static void addMap() {
        s.put('q', new xy(1, 1));
        s.put('w', new xy(1, 2));
        s.put('e', new xy(1, 3));
        s.put('r', new xy(1, 4));
        s.put('t', new xy(1, 5));
        s.put('a', new xy(2, 1));
        s.put('s', new xy(2, 2));
        s.put('d', new xy(2, 3));
        s.put('f', new xy(2, 4));
        s.put('g', new xy(2, 5));
        s.put('z', new xy(3, 1));
        s.put('x', new xy(3, 2));
        s.put('c', new xy(3, 3));
        s.put('v', new xy(3, 4));

        v.put('y', new xy(1, 6));
        v.put('u', new xy(1, 7));
        v.put('i', new xy(1, 8));
        v.put('o', new xy(1, 9));
        v.put('p', new xy(1, 10));
        v.put('h', new xy(2, 6));
        v.put('j', new xy(2, 7));
        v.put('k', new xy(2, 8));
        v.put('l', new xy(2, 9));
        v.put('b', new xy(3, 5));
        v.put('n', new xy(3, 6));
        v.put('m', new xy(3, 7));
    }

}

