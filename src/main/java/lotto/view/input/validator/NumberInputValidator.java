package lotto.view.input.validator;

import static lotto.domain.common.ErrorMessage.INVALID_INPUT;
import static lotto.domain.common.ErrorMessage.NEGATIVE_NUMBER;
import static lotto.domain.common.ErrorMessage.ZERO_START_NUMBER;

import java.util.regex.Pattern;

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
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void validateNotZeroStart(String input) {
        if (input.startsWith(ZERO)) {
            throw new IllegalArgumentException(ZERO_START_NUMBER.getMessage());
        }
    }

    private static void validatePositiveNumber(String input) {
        if (input.startsWith(MINUS_SIGN)) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER.getMessage());
        }
    }

    private static boolean isNumber(String input) {
        return input != null && NUMBER_PATTERN.matcher(input).matches();
    }
}
