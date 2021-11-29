package baseball.ref;

public class EntryPoint {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.initialize();
        game.start();
    }
}
