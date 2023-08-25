package reactive.callback;

public class CallBackDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is running!");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallBackDemo().runningAsync(
                        new CallBack() {
                            @Override
                            public void pushData(String data) {
                                System.out.println("Callback data: " + data);
                            }

                            @Override
                            public void pushCompleted() {
                                System.out.println("Callback done!");
                            }

                            @Override
                            public void pushError(Exception ex) {
                                System.out.println("Callback error called, Got and exception: " + ex);
                            }
                        }
                );
            }
        };

        Thread t = new Thread(r);
        t.start();

        Thread.sleep(3000);
        System.out.println("Main thread completed");
    }

    public void runningAsync(CallBack callBack) {
        System.out.println("I am running on a seperate thread");
        sleep(1000);
        callBack.pushData("Data1");
        callBack.pushData("Data2");
        callBack.pushData("Data3");

        callBack.pushError(new RuntimeException("Oops!"));
        callBack.pushCompleted();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
