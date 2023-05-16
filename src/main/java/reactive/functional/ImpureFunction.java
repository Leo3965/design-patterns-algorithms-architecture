package reactive.functional;

public class ImpureFunction {
    private int value = 0;

    public int add(int nextValue) {
        this.value += value + nextValue;
        return this.value;
    }
}
