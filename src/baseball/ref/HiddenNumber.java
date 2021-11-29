package baseball.ref;

import java.util.List;

public record HiddenNumber(String number, int index) {
    public String judgeWith(List<String> input) {
        String inputNumber = input.get(index);

        if (number.equals(inputNumber)) {
            return "s";
        } else if (input.contains(number)) {
            return "b";
        }

        return null;
    }
}
