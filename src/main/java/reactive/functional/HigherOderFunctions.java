package reactive.functional;

public class HigherOderFunctions {
    public static void main(String[] args) {

        IFactory<Integer> factory = createFactory(
                () -> (Math.random() * 100),
                r -> r.intValue()
        );

        System.out.println(factory.create());
    }

    public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {
        return () -> {
            T product = producer.produce();
            return configurator.configure(product);
        };
    }
}
