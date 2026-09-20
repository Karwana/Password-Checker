package passwordchecker;

public class PasswordChecker {
    /**
    method to check minimum length
    method to check for at least one uppercase letter
    method to check for at least one lowercase letter
    method to check for at least one digit
    method to check for at least one special character
    **/

    public static void checkStrength(String password){}



    public static boolean checkLength(String password){
        if (password.length() < 10) {
            return false;
        }
        return true;
    }

}
