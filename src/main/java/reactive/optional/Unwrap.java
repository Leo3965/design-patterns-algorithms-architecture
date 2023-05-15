package reactive.optional;

import java.util.Optional;

public class Unwrap {
    public static void main(String[] args) {
        Integer a = 10;
        Optional<Integer> optional = Optional.of(a);

        //get is risk if the option is empty and return no such element exception
        Integer integer = optional.get();
        System.out.println(integer);

        //isPresent
        Optional<Integer> empty = Optional.empty();
        Integer integer1 = empty.isPresent() ? optional.get() : 0;
        System.out.println(integer1);

        //orElse, orElseGet
        Integer integer2 = empty.orElse(0);
        System.out.println(integer2);

        Integer integer3 = empty.orElseGet(() -> 0);
        System.out.println(integer3);

        //orElseThrow
        Integer integer4 = empty.orElseThrow(IllegalArgumentException::new);
        System.out.println(integer4);

        //orElseThrow = get()
        Integer integer5 = empty.orElseThrow();
        System.out.println(integer5);
    }
}
