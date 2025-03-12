import java.util.Random;

public class Cable implements SignalComponent {
    private double length;
    private double lossPerKm;
    private double signalStrength;
    private SignalComponent nextComponent;
    private Repeater repeater;
    private Random random = new Random();

    public Cable(double length, double lossPerKm, Repeater repeater) {
        this.length = length;
        this.lossPerKm = lossPerKm;
        this.signalStrength = 100;
        this.repeater = repeater;
    }

    public void transmit(String morseMessage) {
        for (int i = 0; i < length; i++) {
            signalStrength -= lossPerKm;

            if (i % 10 == 0 && random.nextInt(100) < 5) {
                System.out.println("Signal Lost due to random failure");
                return;
            }

            if (repeater != null && signalStrength < 40 && signalStrength >= 20) {
                System.out.println("Repeater detects weak signal at km " + (i + 1) + ", restoring...");
                signalStrength = 100;
                repeater.processSignal(morseMessage);
                break;
            }

            if (signalStrength < 20) {
                System.out.println("[Signal Lost]");
                return;
            }
        }

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
        transmit(signal);
    }
}