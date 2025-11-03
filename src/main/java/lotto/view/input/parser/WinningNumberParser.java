package lotto.view.input.parser;

import static lotto.domain.common.ErrorMessage.INVALID_LOTTO_NUMBER;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.input.validator.LottoNumberValidator;

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
                .map(number -> {
                    number = number.trim();
                    int lottoNumber = convertToInteger(number);
                    LottoNumberValidator.validate(lottoNumber);
                    return lottoNumber;
                })
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
