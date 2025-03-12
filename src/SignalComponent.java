public interface SignalComponent {
    void connect(SignalComponent next);
    void processSignal(String signal);
}