package reactive.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Chaining {
    public static void main(String[] args) {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = System.out::println;

//        c1.accept("HelloRxJava");
//        c2.accept("Java");

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

//        c3.accept("Hi");

//        Consumer<String> c4 = c1.thenAccept(c2).thenAccept(null);
//        c4.accept("Hellouuu");

        UnaryOperator<Integer> f1 = s -> s + 2;
        UnaryOperator<Integer> f2 = s -> s * 2;
        Function<Integer, Integer> f3 = f1.andThen(f2);
        System.out.println(f3.apply(10));
    }
}
