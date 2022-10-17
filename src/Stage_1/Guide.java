package banking;

import java.util.Scanner;

public class Guide {
    static Scanner scanner = new Scanner(System.in);
    private final BankSystem bankSystem;
    private Account currentAccount;

    public Guide() {
        bankSystem = new BankSystem();
    }

    public void startGuide() {
        while (true) {
            startMenu();
            int op = scanner.nextInt();
            switch (op) {
                case 0 -> {
                    System.out.println("Bye!");
                    System.exit(0);
                }
                case 1 -> bankSystem.creatBankAccount();
                case 2 -> {
                    if (logIn()) {
                        while (true) {
                            if (process()) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void startMenu() {
        System.out.println("""
                1. Create an account
                2. Log into account
                0. Exit""");
    }

    public void accountMenu() {
        System.out.println("""
                1. Balance
                2. Log out
                0. Exit""");
    }

    public boolean logIn() {
        System.out.println("Enter your card number:");
        String cardNum = scanner.next();
        System.out.println("Enter your PIN:");
        String pin = scanner.next();
        currentAccount = bankSystem.checkAcc(cardNum, pin);
        if (currentAccount != null) {
            System.out.println("You have successfully logged in!");
            return true;
        } else {
            System.out.println("Wrong card number or PIN!");
            return false;
        }
    }

    public boolean process() {
        accountMenu();
        int op = scanner.nextInt();
        switch (op) {
            case 0 -> {
                System.out.println("Bye!");
                System.exit(0);
            }
            case 2 -> {
                System.out.println("You have successfully logged out!");
                return true;
            }
            case 1 -> System.out.printf("Balance: %f%n", currentAccount.getBalance());
        }
        return false;
    }
}
