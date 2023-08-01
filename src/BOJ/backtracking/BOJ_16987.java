package BOJ.backtracking;

import java.util.*;
import java.io.*;
public class BOJ_16987 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static int n;
    static List<Egg> list = new ArrayList<>();
    static int min = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
            n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine()," ");
                list.add(new Egg(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }


            solve(0,0);
        System.out.println(min);
    }

    public static void solve(int index,int count){
        if(index==n) {
            if(count>min){
                min = count;
            }
            return;
        }

        if(list.get(index).getS() <= 0 || count == n-1) {
            solve(index + 1, count);
            return;
        }

        Egg curEgg = list.get(index);


        int nCnt = count;
        for(int i=0; i<n; i++){
            if(index == i) continue;
            Egg egg = list.get(i);

            if(curEgg.getS()<=0){
                return;
            }
            if(egg.getS()<=0){
                continue;
            }

//            System.out.println("i : "+ i + " index : "+index + " egg : " + egg.getS() + " curEgg : " + curEgg.getS());
            egg.setS(egg.getS()-curEgg.getW());
            curEgg.setS(curEgg.getS()-egg.getW());

                if(egg.getS() <=0){
                    count++;
                }
                if(curEgg.getS()<=0){
                    count++;
                }
                solve(index+1,count);
            egg.setS(egg.getS()+curEgg.getW());
            curEgg.setS(curEgg.getS()+egg.getW());
            count = nCnt;
        }
    }
    static class Egg {
        private int s; //내부도
        private int w; //무게

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }

        @Override
        public String toString() {
            return "egg{" +
                    "s=" + s +
                    ", w=" + w +
                    '}';
        }
    }
}
