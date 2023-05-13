package functional.programming;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {
    public static void main(String[] args) {
        var list = List.of(34, 67, 8, 23, 67, 879, 90);
        Consumer<Integer> consumer = e -> System.out.println("e = " + e);
        printElements(list, consumer);
    }

    private static <T> void printElements(List<T> list, Consumer<T> consumer) {
        for (var l : list) {
            consumer.accept(l);
        }
    }
}
