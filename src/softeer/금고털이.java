package softeer;
import java.io.*;
import java.util.*;

public class 금고털이 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int weight,n,result = 0,resultW=0;
  static PriorityQueue<Met> pq = new PriorityQueue<>();

  public static void main(String[] args) throws IOException{
    String[] input= br.readLine().split(" ");
    weight = Integer.parseInt(input[0]);
    n = Integer.parseInt(input[1]);

    for(int i=0; i<n; i++){
      String[] m = br.readLine().split(" ");
      int w = Integer.parseInt(m[0]);
      int p = Integer.parseInt(m[1]);
      pq.add(new Met(w,p));
    }

    while(true){
      Met met  = pq.poll();
      int metWeight = met.getWeight();
      int metPrice = met.getPrice();

      if(weight<metWeight){
        result = result + weight*metPrice;
        break;
      }else{
        result = result + metWeight*metPrice;
        weight=weight-metWeight;
      }

    }
    System.out.println(result);

  }

  static class Met implements Comparable<Met>{
    private int weight;
    private int price;

    public int getWeight(){
      return weight;
    }

    public int getPrice(){
      return price;
    }

    Met(int w,int p){
      this.weight = w;
      this.price = p;
    }
    @Override
    public int compareTo(Met m1){
      return m1.getPrice() - this.getPrice();
    }

    @Override
    public String toString() {
      return "Met{" +
          "weight=" + weight +
          ", price=" + price +
          '}';
    }
  }
}
