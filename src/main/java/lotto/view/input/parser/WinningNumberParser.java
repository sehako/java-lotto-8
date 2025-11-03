package lotto.view.input.parser;

import static lotto.domain.common.ErrorMessage.INVALID_LOTTO_NUMBER;

import java.util.List;
import lotto.domain.Lotto;

public class WinningNumberParser {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    private WinningNumberParser() {
        throw new IllegalStateException("Utility class");
    }

    public static Lotto parse(String winningNumberInput) {
        List<Integer> winningNumbers = convertToIntegerList(splitWinningNumbers(winningNumberInput));

        return new Lotto(winningNumbers);
    }

    private static List<String> splitWinningNumbers(String winningNumbers) {
        return List.of(winningNumbers.split(WINNING_NUMBER_DELIMITER));
    }

    private static List<Integer> convertToIntegerList(List<String> winningNumberList) {
        return winningNumberList.stream()
                .map(number -> convertToInteger(number.trim()))
                .toList();
    }

    private static int convertToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }
}
