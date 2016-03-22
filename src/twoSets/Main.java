package twoSets;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


    public static void main(String[] args) {
        Set<Integer> set1 = generateNewSet();
        Set<Integer> set2 = generateNewSet();
        System.out.println(union(set1, set2));
        System.out.println(intersect(set1, set2));
    }

    private static Set<Integer> generateNewSet() {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            result.add(ThreadLocalRandom.current().nextInt(10));
        }
        System.out.println(result);
        return result;
    }

    private static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    private static <T> Set<T> intersect(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }
}
