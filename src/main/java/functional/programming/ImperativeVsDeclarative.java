package functional.programming;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {

    public static void main(String[] args) {
        // Imperative
        var sumOfEvens = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sumOfEvens += i;
            }
        }
        System.out.println(sumOfEvens);

        // Declarative or Functional
        var sumEven = IntStream.rangeClosed(0, 100).filter(n -> n%2 == 0).sum();
        System.out.println(sumEven);
    }
}
