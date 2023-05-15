package reactive.optional;

import java.util.Optional;

public class Operations {
    public static void main(String[] args) {
        //  mapFilterAndFlatMap();
        otherMethods();
    }

    private static void mapFilterAndFlatMap() {
        var optional = Optional.of("Value");
        //Optional<String> optional = Optional.empty();

        //map
        var map = optional
                .map(val -> "Replaced")
                .orElse("empty");
        System.out.println(map);

        //filter
        Optional<String> filter = optional
                .filter(val -> val.equalsIgnoreCase("Value"));
        System.out.println(filter.get());

        //flatMap
        Optional<String> flap = optional
                .flatMap(val -> Optional.of("Reaplced"));
        System.out.println(flap.get());
    }

    private static void otherMethods() {
        //ifPresent
        Optional<String> optional = Optional
                .of("Value");
        //      .empty();

        optional.ifPresent(val -> System.out.println("This is a " + val));

        //ifPresentOrElse
        optional.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Value is absent")
        );

        //stream
        optional.stream().forEach(System.out::println);
        Optional.empty().stream().forEach(System.out::println);

        //or
        optional.or(() -> Optional.of("New Value"))
                .ifPresent(System.out::println);
        Optional.empty().or(() -> Optional.of("New Value"))
                .ifPresent(System.out::println);

        //equals
        // is considered equal if the obejcts are optional
        // or both contains equal value
        // or the value of the objects are equal via equals method
        boolean isEqual = optional.equals(Optional.of("Value"));
        System.out.println(isEqual);

        //Hashcode
        System.out.println(optional.hashCode());
        System.out.println(Optional.empty().hashCode());

    }
}
