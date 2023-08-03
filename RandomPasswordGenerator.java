import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {

    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password length you want to make: ");
        int passwordLength = scanner.nextInt();

        System.out.print("Include uppercase letters? (Y/N): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include lowercase letters? (Y/N): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include digits? (Y/N): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include special characters? (Y/N): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("Y");

        scanner.close();

        String password = generateRandomPassword(passwordLength, includeUppercase, includeLowercase, includeDigits, includeSpecialChars);
        System.out.println("Generated Password: " + password);
    }

    public static String generateRandomPassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder passwordBuilder = new StringBuilder();
        String allCharacters = "";

        if (includeUppercase) {
            allCharacters += UPPERCASE_CHARS;
            passwordBuilder.append(getRandomChar(UPPERCASE_CHARS));
        }

        if (includeLowercase) {
            allCharacters += LOWERCASE_CHARS;
            passwordBuilder.append(getRandomChar(LOWERCASE_CHARS));
        }

        if (includeDigits) {
            allCharacters += DIGITS;
            passwordBuilder.append(getRandomChar(DIGITS));
        }

        if (includeSpecialChars) {
            allCharacters += SPECIAL_CHARS;
            passwordBuilder.append(getRandomChar(SPECIAL_CHARS));
        }

        SecureRandom random = new SecureRandom();
        for (int i = passwordBuilder.length(); i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            passwordBuilder.append(allCharacters.charAt(randomIndex));
        }

        return passwordBuilder.toString();
    }

    private static char getRandomChar(String characters) {
        SecureRandom random = new SecureRandom();
        int randomIndex = random.nextInt(characters.length());
        return characters.charAt(randomIndex);
    }
}
