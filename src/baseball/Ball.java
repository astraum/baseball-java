package baseball;

public record Ball(int number, int index) {

    public char throwAt(Target target) {
        if (target.getNumber(index) == number) return 's';   // strike
        if (target.contains(number)) return 'b';             // ball
        return 'n';                                          // no pitch; neither a strike nor a ball
    }
}
