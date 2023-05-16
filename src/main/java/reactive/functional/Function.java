package reactive.functional;

@FunctionalInterface
public interface Function <T, R> {
    R apply(T t);

    default <V> Function<V, R> compose(Function<V, T> before) {
        return (V v) -> apply(before.apply(v));
    }
}
