package reactive.optional;

import java.util.Optional;
import java.util.function.Function;

public class OptionalCreation {
    public static void main(String[] args) {
        var val = "A String";
        Optional<String> optional = Optional.of(val);
        Function<String, Optional<String>> optionalFunction = Optional::of;
        Optional<String> apply = optionalFunction.apply(val);
        //empty
        Optional<Integer> empty = Optional.empty();

        //nullble
        Optional<String> nullable = Optional.ofNullable(val);
        Optional<String> nullable2 = Optional.ofNullable(null);
    }
}

