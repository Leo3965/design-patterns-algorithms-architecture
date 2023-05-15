package reactive.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PracticePredicate {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("Basics");
        list.add("");
        list.add("String");
        list.add("");
        list.add("BasicsString");

        Predicate<String> predicate = s -> !s.isEmpty();
        Predicate<String> filter = e -> e.contains("Basics");
//        List<String> newList = filterList(list, predicate);
        List<String> newList = filterList(list, filter);
        System.out.println(newList);

        List<Integer> integerList = List.of(1, 3, 5, 6, 8);
        Predicate<Integer> integerPredicate = i -> i % 2 == 0;
        var intList = filterList(integerList, integerPredicate);
        System.out.println(intList);
    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        var newList = new ArrayList<T>();
        for (var s : list) {
            if (predicate.test(s)) {
                newList.add(s);
            }
        }
        return newList;
    }
}
