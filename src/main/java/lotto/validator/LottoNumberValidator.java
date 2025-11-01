package lotto.validator;

import static lotto.exception.common.ErrorMessage.INVALID_INPUT;
import static lotto.exception.common.ErrorMessage.ZERO_START_NUMBER;

import java.util.regex.Pattern;
import lotto.exception.InvalidInputException;
import lotto.exception.ZeroStartException;

public class LottoNumberValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public static void validateNumber(String input) {
        if (isNotNumber(input)) {
            throw new InvalidInputException(INVALID_INPUT);
        }
    }

    public static void validateNotZeroStart(String input) {
        if (input.startsWith("0")) {
            throw new ZeroStartException(ZERO_START_NUMBER);
        }
    }

    private static boolean isNotNumber(String input) {
        return !NUMBER_PATTERN.matcher(input).matches();
    }
}
