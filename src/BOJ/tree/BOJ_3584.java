package BOJ.tree;


import java.util.*;
import java.io.*;


public class BOJ_3584 {

    static int repeat, n, root,nodeA,nodeB,depthA,depthB;
    static List<Integer>[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        repeat = Integer.parseInt(br.readLine());

        for (int r = 0; r < repeat; r++) {

            n = Integer.parseInt(br.readLine());
            arr = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < n-1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                arr[child].add(parent); //부모가 자식의 정보는 알 필요 없고 자식만 부모의 정보를 알고 있으면 되므로 자식에만 추가
            }

            st = new StringTokenizer(br.readLine(), " ");
            nodeA = Integer.parseInt(st.nextToken());
            nodeB = Integer.parseInt(st.nextToken());

            depthA = calculateDepth(nodeA);
            depthB = calculateDepth(nodeB);

            if(depthA>depthB){
                int node =nodeA;
                int diff = depthA - depthB;
                for(int i=0; i<diff; i++){
                    node = arr[node].get(0);
                }
                nodeA = node;
            } else if (depthA < depthB) {
                int node =nodeB;
                int diff = depthB - depthA;
                for(int i=0; i<diff; i++){
                    node = arr[node].get(0);
                }
                nodeB = node;
            }
            while(nodeA!=nodeB)
            {
                nodeA = arr[nodeA].get(0);
                nodeB = arr[nodeB].get(0);
            }
            System.out.println(nodeA);
//            for (int i = 1; i < n; i++) { //root 찾기
//                if (arr[i].size() == 0) {
//                    root = i;
//                    break;
//                }
//            }
//
//
//            System.out.println(root);
        }
    }

    private static int calculateDepth(int parent) {
        int depth=0;
        while(true){
            if(arr[parent].size()==0) break;

            parent = arr[parent].get(0);
            depth++;
        }
        return depth;
    }
}
