package passwordchecker;

import java.util.regex.Pattern;

public class PasswordChecker {
    /**
    method to check minimum length --
    method to check for at least one uppercase letter --
    method to check for at least one lowercase letter --
    method to check for at least one digit --
    method to check for at least one special character
    **/

   // public static void checkStrength(String password){}



    public static boolean checkLength(String password) {
        if (password.length() < 10) {
            return false;
        }
        return true;
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

    public static boolean checkForOneDigit(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean checkForSpecialCharacter(String password) {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }


}
