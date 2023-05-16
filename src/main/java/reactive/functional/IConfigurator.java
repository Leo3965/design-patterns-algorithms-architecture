package reactive.functional;

public interface IConfigurator<T, R> {
    R configure(T t);
}
