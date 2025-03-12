import java.util.HashMap;
import java.util.Map;

public class MorseCode {

    private static final Map<Character, String> morseMap = new HashMap<>();
    private static final Map<String, Character> reverseMap = new HashMap<>();

    static {
        String[] morseArray = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        for (int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i);
            morseMap.put(letter, morseArray[i]);
            reverseMap.put(morseArray[i], letter);
        }

        String[] numbersMorse = { "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." };

        for (int i = 0; i < 10; i++) {
            char number = (char) ('0' + i);
            morseMap.put(number, numbersMorse[i]);
            reverseMap.put(numbersMorse[i], number);
        }

    }

    public static String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()) {
            if (morseMap.containsKey(c)) {
                encoded.append(morseMap.get(c)).append(" ");
            } else if (c == ' ') {
                encoded.append("/ ");
            }
        }

        return encoded.toString().trim();
    }

    public static String decode(String morseCode) {
        StringBuilder decoded = new StringBuilder();
        String[] words = morseCode.split(" / ");

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                if (reverseMap.containsKey(letter)) {
                    decoded.append(reverseMap.get(letter));
                }
            }
            decoded.append(" ");
        }

        return decoded.toString().trim();
    }
}
