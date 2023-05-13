package functional.programming;

import java.util.function.Supplier;

public class SupplierPractice {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> new String("A String");
        Supplier<Double> doubleSupplier = () -> Math.random();
        System.out.println(stringSupplier.get());
        System.out.println(doubleSupplier.get());
    }
}
