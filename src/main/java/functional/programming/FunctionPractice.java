package functional.programming;

import java.util.List;
import java.util.function.Function;

public class FunctionPractice {
    public static void main(String[] args) {
        Function<String, Integer> fun = e -> e.length();
        var strList = List.of("Kit", "Kat", "Shake");

        List<Integer> newList = mapTo(strList, fun);
        System.out.println(newList);
    }

    private static <T, R> List<R> mapTo(List<T> strList, Function<T, R> fun) {
        List<R> newList = strList
                .stream()
                .map(e -> fun.apply(e))
                .toList();

        return newList;
    }
}
