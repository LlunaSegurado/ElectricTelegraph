import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message to transmit in Morse: ");
        String message = scanner.nextLine();
        scanner.close();

        TelegraphSystem system = new TelegraphSystem(message);
        system.run(message);
    }
}