package functional.programming;

public class FunctionalGenericsDemo {
    public static void main(String[] args) {
        FunctionalGenerics<String, String> fun = s -> s.substring(1, 5);
        FunctionalGenerics<String, Number> fun1 = s -> s.substring(1, 5).length();
        System.out.println(fun.execute("Leonardo"));
        System.out.println(fun1.execute("Leonardo"));

    }
}
