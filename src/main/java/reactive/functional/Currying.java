package reactive.functional;

public class Currying {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> fun1 = u -> v -> u + v;

        Function<Integer, Integer> fun2 = fun1.apply(10);
        Integer result = fun2.apply(5);
        var finalResult = fun1.apply(13).apply(17);
        System.out.println(result);
        System.out.println(finalResult);

    }
}
