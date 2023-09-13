package programmers;

import java.util.*;
import java.io.*;

public class PRGS_181188 {


    public static void main(String[] args) {
        int[][] target = new int[][]{
                {
                        4, 5
                }, {
                4, 8
        }, {
                10, 14
        }, {
                11, 13
        }, {
                5, 12
        }, {
                3, 7
        }, {
                1, 4
        }
        };


        System.out.println(solution(target));
    }

    public static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int length = targets.length;

        int currentMin = Integer.MAX_VALUE;

        for (int i = length-1; i >= 0; i--) {

            if(targets[i][1] <= currentMin){
                currentMin =targets[i][0];
                answer++;

            }

        }

        return answer;
    }
}
