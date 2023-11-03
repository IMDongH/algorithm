package softeer;
import java.io.*;
import java.util.*;
public class 강의실배정 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,result=0;
    static PriorityQueue<Room> pq = new PriorityQueue<Room>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
      n = Integer.parseInt(br.readLine());
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        pq.add(new Room(start,end));
      }
      int now = 0;
      while(!pq.isEmpty()){
        Room room = pq.poll();
        if(room.getStart()>=now){
          now = room.getEnd();
          result++;
        }
      }
      System.out.println(result);
    }

    static class Room implements Comparable<Room>{
      private int start;
      private int end;

      public Room(int start, int end){
        this.start = start;
        this.end = end;
      }

      public int getStart(){
        return this.start;
      }

      public int getEnd(){
        return this.end;
      }

      @Override
      public int compareTo(Room o){
        return this.getEnd() - o.getEnd();
      }

  }

}
