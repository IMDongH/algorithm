package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    static List<String> names = new ArrayList<>();

    public static void main(String[] args) {

        for(int i=0; i<1000000; i++) {
            names.add(String.valueOf(i));
        }


        /**
         * 중개 오퍼레이션과 종료 오퍼레이션이 존재한다.
         * 중개 오퍼레이션은 stream 을 return 한다.(lazy 하다) - map,filter 등
         * 종료 오퍼레이션 - count,collect 등
         * 다수의 중개 오퍼레이션과 한개의 종료 오퍼레이션이 존재한다.
         * 병럴처리가 된다.
         */
        List<String> collect = names.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("T"))
                .collect(Collectors.toList());

        Func func = new Func();

        /**
         * ex) 병렬 처리 X
         */
        func.calculateTime(() -> {
            int count=0;
            for (String name : names) {
                if(name.startsWith("1")){
                    count ++;
                }
            }
            System.out.println("count = " + count);
        });

        /**
         * ex) 병렬 처리 O
         * 항상 빠르지 않음
         */
        func.calculateTime(() -> {
            System.out.println("count = " + names.parallelStream()
                    .filter((s) -> s.startsWith("1"))
                    .count());
        });

    }



    static class Func {

        void calculateTime(Test func) {
            long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
            func.calculateTime();
            long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
            long diffTime = afterTime - beforeTime; // 두 개의 실행 시간
            System.out.println("실행 시간(ms): " + diffTime); // 세컨드(초 단위 변환)
        }
    }

    interface Test{
        void calculateTime();
    }
}
