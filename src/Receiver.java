public class Receiver implements SignalComponent {
    private String receivedMessage;
    private String originalMessage;

    public Receiver(String originalMessage) {
        this.receivedMessage = "";
        this.originalMessage = originalMessage;
    }

    public void receiveSignal(String morseCode) {
        if (morseCode == null || morseCode.isEmpty() || morseCode.equals("[Signal Lost]")) {
            System.out.println("Error: The received signal is empty or completely degraded.");
            return;
        }
        this.receivedMessage = MorseCode.decode(morseCode);
        checkTransmissionError();
    }

    private void checkTransmissionError() {
        if (!receivedMessage.equalsIgnoreCase(originalMessage)) {
            System.out.println("WARNING: Transmission error detected! The received message does not match the original.");
        }
        displayMessage();
    }

    public void displayMessage() {
        System.out.println("Message received and decoded: " + receivedMessage);
    }

    @Override
    public void connect(SignalComponent next) {
    }

    @Override
    public void processSignal(String signal) {
        receiveSignal(signal);
    }
}