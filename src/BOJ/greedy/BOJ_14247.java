package BOJ.greedy;

import java.util.*;
import java.io.*;

public class BOJ_14247 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static PriorityQueue<Tree> tree = new PriorityQueue<>();
    static long result = 0;
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] growth = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0; i<n; i++){
//            System.out.print("height = " + height[i]);
//            System.out.println("  growth = " + growth[i]);
            tree.add(new Tree(height[i],growth[i]));
        }

        for(int i=0; i<n; i++){
            Tree poll = tree.poll();
            int g = poll.getGrowth();
            int h = poll.getHeight();

            result = result + h + (long)g * (long)i;
//            System.out.println("poll = " + poll);
//            System.out.println(result);
        }

        System.out.println(result);
    }

    private static class Tree implements Comparable<Tree>{
        private int height;
        private int growth;

        public Tree(int height, int growth) {
            this.height = height;
            this.growth = growth;
        }

        public int getHeight() {
            return height;
        }

        public int getGrowth() {
            return growth;
        }


        @Override
        public String toString() {
            return "Tree{" +
                    "height=" + height +
                    ", growth=" + growth +
                    '}';
        }

        @Override
        public int compareTo(Tree o) {
            return this.getGrowth()-o.getGrowth();
        }
    }
}
