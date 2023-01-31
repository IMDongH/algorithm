package BOJ.input;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class BOJ_1924 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> day31 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        List<Integer> day30 = new ArrayList<>(Arrays.asList(4,6,9,11));
        List<Integer> day28 = new ArrayList<>(Arrays.asList(2));


        int total = list.get(1);
        for(int i=2; i<=list.get(0); i++){
            if(day31.contains(i-1)){
                total = total + 31;
            }
            else if(day30.contains(i-1)){
                total = total + 30;
            }
            else {
                total = total + 28;
            }
        }
        int day = total % 7;

        switch (day){
            case 1 : sb.append("MON"); break;
            case 2 : sb.append("TUE"); break;
            case 3 : sb.append("WED"); break;
            case 4 : sb.append("THU"); break;
            case 5 : sb.append("FRI"); break;
            case 6 : sb.append("SAT"); break;
            case 0 : sb.append("SUN"); break;
        }

        System.out.println(sb);
    }
}
