package lotto.view.input.validator;

import static lotto.exception.common.ErrorMessage.INVALID_INPUT;
import static lotto.exception.common.ErrorMessage.NEGATIVE_NUMBER;
import static lotto.exception.common.ErrorMessage.ZERO_START_NUMBER;

import java.util.regex.Pattern;
import lotto.exception.InvalidInputException;

public class NumberInputValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?[0-9]+$");
    private static final String ZERO = "0";
    private static final String MINUS_SIGN = "-";

    public static void validate(String input) {
        validateNumber(input);
        validateNotZeroStart(input);
        validatePositiveNumber(input);
    }

    private static void validateNumber(String input) {
        if (!isNumber(input)) {
            throw new InvalidInputException(INVALID_INPUT);
        }
    }

    private static void validateNotZeroStart(String input) {
        if (input.startsWith(ZERO)) {
            throw new InvalidInputException(ZERO_START_NUMBER);
        }
    }

    private static void validatePositiveNumber(String input) {
        if (input.startsWith(MINUS_SIGN)) {
            throw new InvalidInputException(NEGATIVE_NUMBER);
        }
    }

    private static boolean isNumber(String input) {
        return input != null && NUMBER_PATTERN.matcher(input).matches();
    }
}
