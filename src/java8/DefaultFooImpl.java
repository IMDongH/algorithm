package java8;

public class DefaultFooImpl implements FooInterface{

    String name;

    public DefaultFooImpl(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(name);
    }

    public String getName() {
        return this.name;
    }
}
