package baseball;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private static final int NUMBER_OF_BALLS = 3;

    private final Scanner scanner = new Scanner(System.in);
    private String target = "";
    private int strike = 0;
    private int ball = 0;

    public void initialize() {
        List<String> pool = IntStream.rangeClosed(1, 9).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.shuffle(pool);
        target = String.join("", pool.subList(0, NUMBER_OF_BALLS));
    }

    public void start() {

        System.out.println("숫자야구 게임에 오신 것을 환영합니다.");

        try (scanner) {
            while (strike != NUMBER_OF_BALLS) {
                strike = 0;
                ball = 0;
                tryGuessing();
                printResult();
            }
        } finally {
            System.out.println("정답입니다!");
            System.out.println("게임을 종료합니다.");
        }

    }

    private void tryGuessing() {
        String guess = readUserInput();

        for (int i = 0; i < NUMBER_OF_BALLS; i++) {

            if (guess.charAt(i) == target.charAt(i)) {
                strike += 1;
            } else if (target.indexOf(guess.charAt(i)) != -1) {
                ball += 1;
            }
        }

    }

    private String readUserInput() {

        while (true) {
            System.out.printf("0이 포함되지 않은 %d자리 정수를 입력하세요: ", NUMBER_OF_BALLS);
            String input = scanner.nextLine();
            if (input.matches("[1-9]{" + NUMBER_OF_BALLS + "}")) {
                return input;
            }
            System.out.print("잘못된 입력입니다. ");
        }
    }

    private void printResult() {
        if (strike != 0 || ball != 0) {
            System.out.printf("%d 스트라이크, %d 볼%n", strike, ball);
        } else {
            System.out.println("낫싱");
        }
    }

}
