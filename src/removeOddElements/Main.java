package removeOddElements;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final String SYMBOLS = "йцукенгшщзхъфывапролджэячсмитьбю";
    private static AbstractList<String> oddElements = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 70; i++) {
            oddElements.add(generateString());
        }
        System.out.println(oddElements);
        removeOdd();
    }

    private static String generateString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(3, 10); i++) {
            int i1 = ThreadLocalRandom.current().nextInt(SYMBOLS.length());
            char c = SYMBOLS.charAt(i1);
            sb.append(c);
        }
        return sb.toString();
    }

    private static void removeOdd() {
        for (int i = 69; i > 0; i--) {
            if (!(i % 2 == 0)){
                oddElements.remove(i);
            }
            System.out.println(oddElements);
        }
    }
}
