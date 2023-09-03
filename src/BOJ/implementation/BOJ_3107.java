package BOJ.implementation;

import java.util.*;
import java.io.*;

public class BOJ_3107 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        input = br.readLine();

        if(input.contains("::")){
            input = input.replace("::",":test:");
        }

        String[] list = input.split(":",-1);
        int cnt=0;
        for (String s : list) {
            if(!(s.isEmpty()||s.equals("test"))){
                cnt++;
            }
        }

        int idx=0;
        for(int i=0; i< list.length; i++){

            String s = list[i];

            if(s.isEmpty()) continue;

            if(s.equals("test")){
                for(int j=0; j<8-cnt; j++){
                    sb.append("0000");
                    if(idx<7){
                        sb.append(":");
                    }
                    idx++;
                }
            }
            else{
                if(s.length()==4) {
                    sb.append(s);
                }
                else{
                    for(int j=0; j<4; j++){
                        if(4-j<=s.length()){
                            sb.append(s.charAt(j+s.length()-4));
                        }else{
                            sb.append("0");
                        }
                    }

                }
                if(idx<7){
                    sb.append(":");
                }
                idx++;
            }
        }

        System.out.println(sb);
    }

}