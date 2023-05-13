package functional.programming;

@FunctionalInterface
public interface FunctionalGenerics<T, R> {
    R execute(T t);
}
