package java8;

import java.util.function.Function;

public class Plus10 implements Function<Integer,Integer> {
    //Function<Integer,Integer>
    //          파라미터   return 값
    @Override
    public Integer apply(Integer integer) {
        return integer+10;
    }
}
