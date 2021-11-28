package baseball;

public class Main {
    public static void main(String[] args) {
        System.out.println("숫자야구 게임에 오신 것을 환영합니다.");
        Game game = new Game();

        do {
            game.playBall();
        } while (!game.isWon());

        System.out.println("정답입니다!");
        System.out.println("게임을 종료합니다.");
    }
}
