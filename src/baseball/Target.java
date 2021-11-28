package baseball;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Target {

    private final List<Integer> targetNumbers;

    public Target(int n) {
        List<Integer> pool = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toList());
        Collections.shuffle(pool);
        targetNumbers = pool.subList(0, n);
    }

    public int getNumber(int index) {
        return targetNumbers.get(index);
    }

    public boolean contains(int number) {
        return targetNumbers.contains(number);
    }
}

