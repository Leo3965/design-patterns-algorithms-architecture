package reactive.lambda;

public class LambdaExample1 {

    public static void main(String[] args) {
        lambda();
        MyFuncInterface my = () -> System.out.println("HelloRxJava");
        my.myMethod();
    }

    public static void normal() {
        MyRunnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();
    }

    public static void anonymous() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Executed!");
            }
        });
    }

    //Properties
    //Name of parameters
    //Function's body
    //Return
    public static void lambda() {
        Thread t = new Thread(() -> System.out.println("Thread Executed!"));
        t.start();
    }
}
