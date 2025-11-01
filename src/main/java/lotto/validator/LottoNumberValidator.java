package lotto.validator;

import static lotto.exception.common.ErrorMessage.INVALID_INPUT;

import java.util.regex.Pattern;
import lotto.exception.InvalidInputException;

public class LottoNumberValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public static void validateNumber(String input) {
        if (isNotNumber(input)) {
            throw new InvalidInputException(INVALID_INPUT);
        }
    }

    private static boolean isNotNumber(String input) {
        return !NUMBER_PATTERN.matcher(input).matches();
    }
}
