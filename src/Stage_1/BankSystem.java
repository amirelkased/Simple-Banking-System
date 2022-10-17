package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static banking.CardGenerator.*;

public class BankSystem {
    private static final List<Account> accounts = new ArrayList<>();

    public void creatBankAccount() {
        while (true) {
            String card = createCard();
            if (checkCardNum(card)) {
                Account account = new Account(card, pinGenerator());
                accounts.add(account);
                displayDetails(account.getAccountNumber(), account.getPIN());
                break;
            }
        }
    }

    private void displayDetails(String accountNum, String BIN) {
        System.out.println("Your card has been created");
        System.out.printf("Your card number:%n%s%n", accountNum);
        System.out.printf("Your card PIN:%n%s%n", BIN);
    }

    private boolean checkCardNum(String num) {
        for (var it : accounts) {
            if (Objects.equals(it.getAccountNumber(), num)) {
                return false;
            }
        }
        return true;
    }

    public Account checkAcc(String cardNum, String pin) {
        for (var it : accounts) {
            if (Objects.equals(it.getAccountNumber(), cardNum) && Objects.equals(it.getPIN(), pin)) {
                return it;
            }
        }
        return null;
    }
}
