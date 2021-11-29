package baseball.ref;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Round {
    private static final int NUMBER_OF_BALLS = 3;

    private final Scanner scanner;
    private List<String> userInput;

    public Round(Scanner scanner) {
        this.scanner = scanner;
    }

    public Judgement judge(List<HiddenNumber> hiddenNumbers) {
        System.out.printf("output : %s\n", userInput.toString());
        List<String> strings = hiddenNumbers.stream()
                .map(hiddenNumber -> hiddenNumber.judgeWith(userInput))
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());
        return new Judgement(strings);
    }

    public void waitUserInput() {
        while (true) {
            System.out.printf("0이 포함되지 않은 %d자리 정수를 입력하세요: ", NUMBER_OF_BALLS);
            String input = scanner.nextLine();

            if (!input.matches("[1-9]{" + NUMBER_OF_BALLS + "}")) {
                System.out.print("잘못된 입력입니다. ");
                continue;
            }

            this.userInput = Arrays.stream(input.replaceAll("([1-9])", "_$1").substring(1).split("_")).toList();
            this.scanner.close();
            break;
        }
    }
}
