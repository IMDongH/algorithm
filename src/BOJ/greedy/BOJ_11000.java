package BOJ.greedy;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class BOJ_11000 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<Room> room = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            room.add(new Room(ints[0],ints[1]));
        }

        Collections.sort(room, (o1,o2) -> o2.getStart()-o1.getStart()!=0 ? o1.getStart()-o2.getStart() : o1.getEnd() -o2.getEnd() );

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(room.get(0).getEnd());
        int sum=0;
            for(int i=1; i<room.size(); i++){
                if(room.get(i).getStart()>=pq.peek()){
                    pq.poll();

                }
                pq.offer(room.get(i).getEnd());
            }
        System.out.println(pq.size());
    }

    static class Room{
        private int start;
        private int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
