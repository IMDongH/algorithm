package BOJ.input;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class BOJ_11719 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String line = null;


        while((line = br.readLine())!=null){
            sb.append(line+"\n");
        }
        System.out.print(sb);
    }
}
