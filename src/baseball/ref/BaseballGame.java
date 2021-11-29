package baseball.ref;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballGame {
    private List<HiddenNumber> numberObjects;

    public void initialize() {
        List<String> list = IntStream.range(1, 9).boxed().map(Objects::toString).collect(Collectors.toList());
        Collections.shuffle(list);
        List<String> hiddenNumbers = list.subList(0, 3);
        numberObjects = new ArrayList<>();
        for (int i = 0; i < hiddenNumbers.size(); i++) {
            numberObjects.add(new HiddenNumber(hiddenNumbers.get(i), i));
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            while (true) {
                Round round = new Round(scanner);
                round.waitUserInput();
                Judgement judge = round.judge(numberObjects);
                judge.printResult();

                if (isFinished(judge)) {
                    break;
                }
            }
        }
    }

    private boolean isFinished(Judgement judge) {
        return judge.getStrikeCount() == 3;
    }
}
