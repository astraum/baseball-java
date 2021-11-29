package baseball.ref;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
    private final int strikeCount;
    private final int ballCount;

    public Judgement(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public Judgement(List<String> judge) {
        this((int) judge.stream().filter("s"::equals).count(), (int) judge.stream().filter("b"::equals).count());
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    @Override
    public String toString() {
        if (strikeCount == 0 && ballCount == 0) {
            return "Nothing";
        }
        List<String> result = new ArrayList<>();
        if (ballCount != 0) {
            result.add(String.format("%d Balls", ballCount));
        }
        if (strikeCount != 0) {
            result.add(String.format("%d Strikes", strikeCount));
        }
        return String.join(", ", result);
    }

    public void printResult() {
        System.out.println(this);
    }
}
