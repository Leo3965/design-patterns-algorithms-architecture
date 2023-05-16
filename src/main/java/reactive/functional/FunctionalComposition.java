package reactive.functional;

public class FunctionalComposition {
    public static void main(String[] args) {
        Function<Square, Integer> func1 = s -> s.getArea();
        Function<Integer, Double> func2 = area -> Math.sqrt(area);

        Function<Square, Double> getSide = func2.compose(func1);
        var square = new Square();

        square.setArea(100);
        Double side = getSide.apply(square);

        System.out.println(side);

    }
}
