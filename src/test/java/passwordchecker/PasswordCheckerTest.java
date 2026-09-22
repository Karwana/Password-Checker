package passwordchecker;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {


    @org.junit.jupiter.api.Test
    void checkLength() {
        String failedPw = "abc";
        boolean failedResult = PasswordChecker.checkLength(failedPw);
        assertFalse(failedResult);

        String passedPw = "abcdefghij";
        boolean passedResult = PasswordChecker.checkLength(passedPw);
        assertTrue(passedResult);

    }

    @org.junit.jupiter.api.Test
    void checkUpperCase() {
        String failedPw = "abc";
        boolean failedResult = PasswordChecker.checkUpperCase(failedPw);
        assertFalse(failedResult);

        String passedPw = "Abcdefghij";
        boolean passedResult = PasswordChecker.checkUpperCase(passedPw);
        assertTrue(passedResult);
    }

    @org.junit.jupiter.api.Test
    void checkLowerCase() {
        String failedPw = "ABC";
        boolean failedResult = PasswordChecker.checkLowerCase(failedPw);
        assertFalse(failedResult);

        String passedPw = "ABCDEFGHIJk";
        boolean passedResult = PasswordChecker.checkLowerCase(passedPw);
        assertTrue(passedResult);
    }

    @org.junit.jupiter.api.Test
    void checkForOneDigit() {
        String failedPw = "abc";
        boolean failedResult = PasswordChecker.checkForOneDigit(failedPw);
        assertFalse(failedResult);

        String passedPw = "abcdefghij1";
        boolean passedResult = PasswordChecker.checkForOneDigit(passedPw);
        assertTrue(passedResult);
    }

    @org.junit.jupiter.api.Test
    void checkForSpecialCharacter() {
        String failedPw = "abc";
        boolean failedResult = PasswordChecker.checkForSpecialCharacter(failedPw);
        assertFalse(failedResult);

        String passedPw = "abc@";
        boolean passedResult = PasswordChecker.checkForSpecialCharacter(passedPw);
        assertTrue(passedResult);
    }
}