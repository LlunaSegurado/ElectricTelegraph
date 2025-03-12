public class Repeater implements SignalComponent {
    private SignalComponent nextComponent;
    private int battery = 3;

    public Repeater() {}

    public void amplify(String morseMessage) {
        if (battery > 0) {
            System.out.println("Signal restored and amplified by the repeater.");
            battery--;
            if (nextComponent != null) {
                nextComponent.processSignal(morseMessage);
            }
        } else {
            System.out.println("Repeater out of battery!");
        }
    }

    @Override
    public void processSignal(String morseMessage) {
        amplify(morseMessage);
    }

    @Override
    public void connect(SignalComponent next) {
        this.nextComponent = next;
    }
}