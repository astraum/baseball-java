package baseball;

import java.util.Scanner;

public class Game {

    private static final int NUMBER_OF_BALLS = 3;

    private final Scanner scanner = new Scanner(System.in);
    private final Target target;
    private Score lastScore;

    public Game() {
        target = new Target(NUMBER_OF_BALLS);
    }

    public void playBall() {

        String guess = userInput();
        Pitch pitch = new Pitch(guess);
        lastScore = new Score(pitch, target);
        System.out.println(lastScore);
    }

    public boolean isWon() {
        return lastScore.getStrike() == NUMBER_OF_BALLS;
    }

    private String userInput() {

        while (true) {
            System.out.printf("0이 포함되지 않은 %d자리 정수를 입력하세요: ", NUMBER_OF_BALLS);
            String input = scanner.nextLine();
            if (input.matches("[1-9]{" + NUMBER_OF_BALLS + "}")) return input;
            System.out.print("잘못된 입력입니다. ");
        }
    }

}
