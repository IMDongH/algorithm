    package BOJ.shortestPath;

    import java.util.*;
    import java.io.*;


    public class BOJ_1916 {
        static int n, m;
        static List<List<Bus>> bus = new ArrayList<>();
        static int start,end;
        static int shortest[];
//        static boolean visited[];
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static void main(String[] args) throws IOException{
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            shortest = new int[n+1];
//            visited = new boolean[n+1];
            for(int i=0; i<=n; i++){
                bus.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++){
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                bus.get(input[0]).add(new Bus(input[1],input[2]));
            }
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            start = input[0];
            end = input[1];

            for (List<Bus> list : bus) {
                list.sort((o1,o2) -> o1.getPrice()-o2.getPrice());
            }

    //        for (List<Bus> buses : bus) {
    //            for (Bus bus1 : buses) {
    //                System.out.print(bus1);
    //            }
    //            System.out.println();
    //        }
            Arrays.fill(shortest,Integer.MAX_VALUE);

            shortest[start] = 0;
//            visited[start] = true;
            solve(start);


            System.out.println(shortest[end]);
        }

        private static void solve(int now){
            PriorityQueue<Bus> queue = new PriorityQueue<>();
            queue.add(new Bus(now,0));

            while(!queue.isEmpty()){
                Bus poll = queue.poll();
                List<Bus> busList = bus.get(poll.getDes());

                if(poll.price>shortest[poll.des]) continue;

                for (Bus b : busList) {
                    int destination = b.getDes();
                    int price = b.getPrice();
//                    if(shortest[destination]==Integer.MAX_VALUE){
                        if(shortest[destination]>shortest[poll.getDes()]+price) {
                            shortest[destination] = shortest[poll.getDes()] + price;
                            queue.add(new Bus(destination, shortest[destination]));
                        }
//                        break;
//                    }
                }
            }
        }
        private static class Bus implements Comparable<Bus>{
            private int des;
            private int price;

            public Bus(int des, int price) {
                this.des = des;
                this.price = price;
            }

            public int getDes() {
                return des;
            }

            public int getPrice() {
                return price;
            }


            @Override
            public int compareTo(Bus o) {
                return price-o.getPrice();
            }
        }
    }
