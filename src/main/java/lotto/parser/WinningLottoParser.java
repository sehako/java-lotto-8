package lotto.parser;

import java.util.List;
import lotto.domain.Lotto;

public class WinningLottoParser {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static Lotto parse(String winningNumbers) {
        List<String> winningNumberList = splitWinningNumbers(winningNumbers);

        return new Lotto(convertToIntegerList(winningNumberList));
    }

    private static List<String> splitWinningNumbers(String winningNumbers) {
        return List.of(winningNumbers.split(WINNING_NUMBER_DELIMITER));
    }

    private static List<Integer> convertToIntegerList(List<String> winningNumberList) {
        return winningNumberList.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
