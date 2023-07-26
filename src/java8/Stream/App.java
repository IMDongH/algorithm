package java8.Stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(2,"spring jpa",true));
        springClasses.add(new OnlineClass(3,"spring mvc",false));
        springClasses.add(new OnlineClass(4,"spring core",false));
        springClasses.add(new OnlineClass(5,"rest api ",false));

        System.out.println("\nspring 으로 시작하는 수업");
        springClasses.stream()
                .filter(s -> s.getTitle().startsWith("spring"))
                        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("\nclose 되지 않은 수업");
        springClasses.stream()
                .filter(oc -> !oc.isClosed())
//                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("\n수업 이름만 모으기");
        springClasses.stream()
                .map(sc -> sc.getTitle())
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6,"The java, Test",true));
        javaClasses.add(new OnlineClass(7,"The java, code",true));
        javaClasses.add(new OnlineClass(8,"The java, 8 to 11",false));


        List<List<OnlineClass>> dongEvents = new ArrayList<>();
        dongEvents.add(springClasses);
        dongEvents.add(javaClasses);


        System.out.println("\n두 수업 목록에 들어있는 모든 수업 아이디 출력");
        dongEvents.stream()
//                .flatMap(list -> list.stream())
                .flatMap(Collection::stream)
                .map(OnlineClass::getId)
                .forEach(System.out::println);

        System.out.println("\n10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10 개 뺴고 최대 10개 까지만");
        Stream.iterate(10,i->i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\n자바 수업 중 Test 가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().map(OnlineClass::getTitle).allMatch(t -> t.contains("Test"));
        System.out.println("test = " + test);


        System.out.println("\n스프링 수업 중 제목에 spring이 들어간 것만 모아서 List로 만들기");
        List<String> spring = springClasses.stream().filter(s -> s.getTitle().contains("spring")).map(OnlineClass::getTitle).collect(Collectors.toList());
        spring.forEach(System.out::println);
    }
}
