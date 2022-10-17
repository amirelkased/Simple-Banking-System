package banking;

import java.util.Random;

public class CardGenerator {

    public static String createCard() {
        StringBuilder card;
        card = new StringBuilder("400000");
        while (card.length() != 16) {
            card.append(randNum());
        }
        return card.toString();
    }

    public static String pinGenerator() {
        return String.valueOf((int) (Math.random() * 10000));
    }

    private static int randNum() {
        return new Random().nextInt(10);
    }
}
