public class Transmitter implements SignalComponent {
    private boolean isOn;
    private SignalComponent nextComponent;

    public Transmitter() {
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("Transmitter is now ON.");
    }

    public void send_signal(String message) {
        if (!isOn) {
            System.out.println("Transmitter OFF");
            return;
        }
        String morseMessage = MorseCode.encode(message);
        System.out.println("Morse coded signal: " + morseMessage);
        if (nextComponent != null) {
            nextComponent.processSignal(morseMessage);
        }
    }

    @Override
    public void connect(SignalComponent next) {
        this.nextComponent = next;
    }

    @Override
    public void processSignal(String signal) {
        send_signal(signal);
    }
}