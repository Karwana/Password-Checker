package passwordchecker;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

public class PasswordChecker {

    static final int LENGTH_POINTS = 2;
    static final int UPPER_POINTS = 2;
    static final int LOWER_POINTS = 2;
    static final int DIGIT_POINTS = 2;
    static final int CHARACTER_POINTS = 2;

    private static final List<Map.Entry<Function<String, Boolean>, Integer>> CRITERIA = List.of(
            Map.entry(PasswordChecker::checkLength, LENGTH_POINTS),
            Map.entry(PasswordChecker::checkUpperCase, UPPER_POINTS),
            Map.entry(PasswordChecker::checkLowerCase, LOWER_POINTS),
            Map.entry(PasswordChecker::checkDigit, DIGIT_POINTS),
            Map.entry(PasswordChecker::checkSpecialCharacter, CHARACTER_POINTS)
    );

    public static int totalStrength(String password) {
        int score = 0;
        for (var entry : CRITERIA) {
            if (entry.getKey().apply(password)) {
                score += entry.getValue();
            }
        }
        return score;
    }

    public static boolean checkLength(String password) {
        return password.length() >= 10;
    }

    public static boolean checkUpperCase(String password) {
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        if (!hasUpperCase) {
            System.out.println("Must contain at least (1) (upper) case.");
        }
        return hasUpperCase;
    }

    public static boolean checkLowerCase(String password) {
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        if (!hasLowerCase) {
            System.out.println("Must contain at least (1) (lower) case");
        }
        return hasLowerCase;
    }

    public static boolean checkDigit(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean checkSpecialCharacter(String password) {
        return Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]").matcher(password).find();
    }


}
