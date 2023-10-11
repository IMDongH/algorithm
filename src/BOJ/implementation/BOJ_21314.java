package BOJ.implementation;

import java.util.*;
import java.io.*;

public class BOJ_21314 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] input;
    static int nowIdx = 0;
    static ArrayList<Num> mA = new ArrayList<>();
    static ArrayList<Num> kA = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        input = str.split("");

        mA.add(new Num("M", "1"));
        kA.add(new Num("K", "5"));

        for (int i = 1; i <str.length(); i++) {
            mA.add(new Num(mA.get(i-1).getMinN() + "M", mA.get(i-1).getDec() + "0"));
            kA.add(new Num("M"+kA.get(i-1).getMinN(), kA.get(i-1).getDec() + "0"));
        }



        int length = str.length()-1;
        String max = str;
        for(int i=length; i>=0; i--){
            Num num = kA.get(i);

            if(max.contains(num.getMinN()))
            {
                max = max.replace(num.getMinN(),num.getDec());
            }
        }
        max = max.replaceAll("M","1");

        length = str.length()-1;
        String min = str;
        for(int i=length; i>=0; i--){
            Num num = mA.get(i);

            if(min.contains(num.getMinN()))
            {
                min = min.replace(num.getMinN(),num.getDec());
            }
        }
        min = min.replaceAll("K","5");
        System.out.println(max);
        System.out.println(min);
    }

    static class Num {
        private String minN;
        private String dec;

        public String getMinN() {
            return minN;
        }

        public Num(String minN, String dec) {
            this.minN = minN;
            this.dec = dec;
        }

        public String getDec() {
            return dec;
        }

        @Override
        public String toString() {
            return "Num{" +
                    "minN='" + minN + '\'' +
                    ", dec='" + dec + '\'' +
                    '}';
        }
    }
}
