package java8;

public interface FooInterface {

    void printName();

    String getName();

    /**
     * @implSpec
     * 이 구현체는 ~
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }


    static void printAnything(){
        System.out.println("test");
    }
    /**
     * Object 에서 제공하는 method (equals,toString 등등) 은 default로 재정의 할 수 없음
     * 추상 메서드로 선언하는건 상관 X
     */
}
