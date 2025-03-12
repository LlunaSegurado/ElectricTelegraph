import java.util.ArrayList;
import java.util.List;

public class TelegraphSystem {
    private List<SignalComponent> components = new ArrayList<>();
    private Transmitter transmitter;
    private Receiver receiver;

    public TelegraphSystem(String message) {
        this.transmitter = new Transmitter();
        this.receiver = new Receiver(message);

        // Configure components
        Repeater repeater1 = new Repeater();
        Repeater repeater2 = new Repeater();

        transmitter.turnOn();
        components.add(transmitter);
        components.add(new Cable(50, 10.0, repeater1));
        components.add(new Cable(30, 5.0, repeater2));
        components.add(new Cable(10, 2.0, null));
        components.add(receiver);

        for (int i = 0; i < components.size() - 1; i++) {
            components.get(i).connect(components.get(i + 1));
        }
    }

    public void run(String message) {
        transmitter.send_signal(message);
    }
}