package reactive.functional;

public class Clousure {
    public static void main(String[] args) {
        int val = 11;
        Task lambda = () -> {
            System.out.println(val);
            System.out.println("Task Completed");
        };

        prinValue(lambda);
    }

    private static void prinValue(Task lambda) {
        lambda.doTask();
    }
}
