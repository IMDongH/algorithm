package java8.Optional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(2,"spring jpa",true));
        springClasses.add(new OnlineClass(3,"spring mvc",false));
        springClasses.add(new OnlineClass(4,"spring core",false));
        springClasses.add(new OnlineClass(5,"rest api ",false));


        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("e"))
                .findFirst();

          // 이렇게 get 하기 전에 확인을 해야하는 번거로움이 있음
//        OnlineClass onlineClass = spring.get();
        // 다음과 같이 처리 가능하다 ifPresent
//        spring.ifPresent(oc -> System.out.println(oc.getTitle()));

        // 없으면 괄호 안의 값을 return 해라 - 있더라도 괄호안의 creatnew 실행된다.
//        OnlineClass onlineClass = spring.orElse(createNewClasses());
//        System.out.println("onlineClass = " + onlineClass.getTitle());

        //값이 있는 경우 괄호안의 create 가 실행되지 않는다.
        OnlineClass onlineClass = spring.orElseGet(App::createNewClasses);
        System.out.println("onlineClass = " + onlineClass.getTitle());
    }

    private static OnlineClass createNewClasses() {

        System.out.println("create new class");
        return new OnlineClass(10,"newClass",false);
    }
}
