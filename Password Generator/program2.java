import java.security.*;
import java.util.*;

public class program2 {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String DIGIT = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;':,.<>?";
    private static final String PASSWORD_CHARACTERS = CHAR_LOWER + CHAR_UPPER + DIGIT + SPECIAL_CHARS;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int passwordLength = sc.nextInt();

        System.out.print("Enter the number of passwords to generate: ");
        int numPasswords = sc.nextInt();

        for (int i = 0; i < numPasswords; i++) {
            String password = generateRandomPassword(passwordLength);
            System.out.println("Generated Password " + (i + 1) + ": " + password);
            // Save the password in encrypted form
            String encryptedPassword = encryptPassword(password);
            System.out.println("Encrypted Password: " + encryptedPassword);
            System.out.println();
        }
    }

    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder(length);
        Random random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(PASSWORD_CHARACTERS.length());
            password.append(PASSWORD_CHARACTERS.charAt(randomIndex));
        }

        return password.toString();
    }

    public static String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(password.getBytes());

            StringBuilder encryptedPassword = new StringBuilder();
            for (byte b : hash) {
                encryptedPassword.append(String.format("%02x", b));
            }
            return encryptedPassword.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}