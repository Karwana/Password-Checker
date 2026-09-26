package passwordchecker;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        boolean running = true;

        while (running) {

            System.out.println("(Welcome to Password-Checker)");
            System.out.println("(1) Check password strength");
            System.out.println("(2) Generate safe password");
            System.out.println("(3) Exit");
            String choice = scanner.nextLine();

            switch (choice) {

                case "1" -> passwordStrengthMenu();
                case "2" -> generatePasswordMenu();
                case "3" -> running = false;
            }
        }
    }

    public static void passwordStrengthMenu() {
        System.out.println("Please enter password to see strength: ");
        String password = scanner.nextLine();
        System.out.println("Total password score: " + PasswordChecker.totalStrength(password) + "/10");
        List<String> tips = PasswordChecker.getImprovementTips(password);
        if (!tips.isEmpty()) {
            System.out.println("Things to improve: " + String.join(", ", tips) + "\n");
        } else {
            System.out.println("Great password!\n");
        }
    }

    public static void generatePasswordMenu() {
        System.out.println("Secure password generator");
        System.out.println("(1) Generate password");
        System.out.println("(2) Back to main menu");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            String safepw = PasswordChecker.generateStrongPassword();
            System.out.println("Your generated password: " + safepw + "\n");
        }
    }


    public static void main(String[] args) {
        mainMenu();
    }
}
