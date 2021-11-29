package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pitch {

    private final List<Ball> balls = new ArrayList<>();

    public Pitch(String guess) {
        List<Integer> tries = Stream.of(guess.getBytes())
                .map(String::new)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < tries.size(); i++) {
            balls.add(new Ball(tries.get(i), i));
        }
    }

    public char[] throwAt(Target target) {
        char[] result = new char[balls.size()];
        for (Ball ball : balls) {
            result[ball.index()] = ball.throwAt(target);
        }
        return result;
    }

}
