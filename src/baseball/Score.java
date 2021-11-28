package baseball;

public class Score {

    private int strike = 0;
    private int ball = 0;

    public Score(Pitch pitch, Target target) {
        char[] pitchResult = pitch.throwAt(target);
        for (char c : pitchResult) {
            if (c == 's') strike += 1;
            if (c == 'b') ball += 1;
        }
    }

    public int getStrike() {
        return strike;
    }

    public String toString() {
        if (strike == 0 && ball == 0) return "낫싱!";
        return strike + " 스트라이크, "+ ball + "볼";
    }

}
