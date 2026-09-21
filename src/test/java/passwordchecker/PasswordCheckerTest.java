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
    }

    @org.junit.jupiter.api.Test
    void checkLowerCase() {
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
}