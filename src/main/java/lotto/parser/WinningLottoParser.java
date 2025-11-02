package lotto.parser;

import java.util.List;
import lotto.domain.Lotto;
import lotto.validator.NumberInputValidator;

public class WinningLottoParser {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static Lotto parse(String winningNumberInput) {
        List<Integer> winningNumbers = convertToIntegerList(splitWinningNumbers(winningNumberInput));

        return new Lotto(winningNumbers);
    }

    private static List<String> splitWinningNumbers(String winningNumbers) {
        return List.of(winningNumbers.split(WINNING_NUMBER_DELIMITER));
    }

    private static List<Integer> convertToIntegerList(List<String> winningNumberList) {
        return winningNumberList.stream()
                .map(number -> {
                    NumberInputValidator.validate(number);
                    return Integer.parseInt(number);
                })
                .toList();
    }
}
