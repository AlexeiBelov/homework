package removeOddElements;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final String SYMBOLS = "йцукенгшщзхъфывапролджэячсмитьбю";
    private static final Deque<String> oddElements = new LinkedList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 70; i++) {
            oddElements.add(generateString());
        }
        System.out.println(oddElements);
        removeOdd();
        System.out.println(oddElements);

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
        Iterator<String> it = oddElements.descendingIterator();
        int index = oddElements.size();
        while (it.hasNext()) {
            it.next();
            if (index-- % 2 == 0) {
                it.remove();
            }
        }
    }
}
