package passwordchecker;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        boolean running = true;

        while (running) {

            System.out.println("(Welcome to Password-Checker)\n");
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
        System.out.println("Total password score: " + PasswordChecker.totalStrength(password));
        System.out.println("Things to improve: " + PasswordChecker.getImprovementTips(password));
    }

    public static void generatePasswordMenu() {
        System.out.println("Secure password generator\n");
        System.out.println("(1) Generate password");
        System.out.println("(2) Back to main menu");
        String choice = scanner.nextLine();

        if (choice == "2") {
            mainMenu();
        }
    }


    public static void main(String[] args) {
        mainMenu();
    }
}
