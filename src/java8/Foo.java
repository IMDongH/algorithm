package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Foo {

    public static void main(String[] args) {

        //익명 내부 클래스
//        RunSomething runSomethingRamda = (msg) -> {
//            System.out.println(msg);
//        };
//
//        runSomethingRamda.doIt("test");

//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(10) );

//        Function<Integer,Integer> plus10 = (i) -> i+10;
//        Function<Integer,Integer> mul2 = (i) -> i*2;
//        Function<Integer,Integer> min4 = (i) -> i-4;
//
//
//        System.out.println(plus10.compose(mul2).andThen(min4).apply(10));

//        BiFunction<T,U,R> - 파라미터 2개 가능
//        Consumer -> return 값이 없음

//        DefaultFooImpl foo = new DefaultFooImpl("dong");
//        foo.printName();
//        foo.printNameUpperCase();

        List<String> name = new ArrayList<>();
        name.add("im");
        name.add("dong");
        name.add("hyeok");
        name.add("test");

//        name.forEach((e) -> {
//            System.out.println("name = " + e);
//        });

//        name.forEach(System.out::println);

//        Spliterator<String> spliterator = name.spliterator();
//        while (spliterator.tryAdvance(System.out::println));


    }
}
