package baseball;

import java.util.ArrayList;
import java.util.List;

public class Pitch {

    private final List<Ball> balls = new ArrayList<>();

    public Pitch(String guess) {
        for (int i = 0; i < guess.length(); i++) {
            int number = guess.charAt(i) - '0';
            balls.add(new Ball(number, i));
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
