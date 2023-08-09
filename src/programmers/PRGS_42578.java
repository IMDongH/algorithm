package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class PRGS_42578 {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.solution(new String[][]{});
    }


    class Solution {
        public int solution(String[][] clothes) {
            return Arrays.stream(clothes)
                    .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                    .values()
                    .stream()
                    .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
        }
    }

//    static class Solution {
//        public int solution(String[][] clothes) {
//            int answer = 1;
//            Map<String, Integer> map = new HashMap<>();
//            for (String[] clothe : clothes) {
//                if(map.containsKey(clothe[1])){
//                    map.put(clothe[1],map.get(clothe[1])+1);
//                }else{
//                    map.put(clothe[1],2);
//                }
//            }
//            for (Integer value : map.values()) {
//                answer*=value;
//            }
//                return answer-1;
//
//        }
//    }
}
