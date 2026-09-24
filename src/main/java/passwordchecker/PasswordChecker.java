package passwordchecker;

import java.util.ArrayList;
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
    static final String lengthTip = "Use at least 10 characters";
    static final String upperTip = "Use capital letters";
    static final String lowerTip = "Use lowercase letters";
    static final String digitTip = "Use digits";
    static final String characterTip = "Use special characters";

    private static final List<Map.Entry<Function<String, Boolean>, Integer>> CRITERIA = List.of(
            Map.entry(PasswordChecker::checkLength, LENGTH_POINTS),
            Map.entry(PasswordChecker::checkUpperCase, UPPER_POINTS),
            Map.entry(PasswordChecker::checkLowerCase, LOWER_POINTS),
            Map.entry(PasswordChecker::checkDigit, DIGIT_POINTS),
            Map.entry(PasswordChecker::checkSpecialCharacter, CHARACTER_POINTS)
    );

    private static final List<Map.Entry<Function<String, Boolean>, String>> TIPS = List.of(
            Map.entry(PasswordChecker::checkLength, lengthTip),
            Map.entry(PasswordChecker::checkUpperCase, upperTip),
            Map.entry(PasswordChecker::checkLowerCase, lowerTip),
            Map.entry(PasswordChecker::checkDigit, digitTip),
            Map.entry(PasswordChecker::checkSpecialCharacter, characterTip)
    );

    public static List<String> getImprovementTips(String password) {
        List<String> tips = new ArrayList<>();
        for (var tip : TIPS) {
            if (!tip.getKey().apply(password)) {
                tips.add(tip.getValue());
            }
        }
        return tips;
    }

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
        return !password.equals(password.toLowerCase());
    }

    public static boolean checkLowerCase(String password) {
        return !password.equals(password.toUpperCase());
    }

    public static boolean checkDigit(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean checkSpecialCharacter(String password) {
        return Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]").matcher(password).find();
    }


}
