package java8;

public interface Bar extends FooInterface{
    void printNameUpperCase(); //FooInterface 에 있는 default 메소드를 재정의 할 수 있음


    /**
     * extends 를 하지 않고 아래와 같이 Bar 와 FooInterface 에 선언되어잇는 경우 구현체에서 컴파일 에러가 발생한다.
     */
//    default void printNameUpperCase() {
//        System.out.println(getName().toUpperCase());
//    }
}
