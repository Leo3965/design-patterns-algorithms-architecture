package reactive.callback;

public interface CallBack {
    void pushData(String data);
    void pushCompleted();
    void pushError(Exception ex);
}
