package lotto.view.input.parser;

import static lotto.domain.common.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import lotto.view.input.validator.NumberInputValidator;

public class BonusNumberParser {

    private BonusNumberParser() {
        throw new IllegalStateException("Utility class");
    }

    public static int parse(String bonusNumberString) {
        NumberInputValidator.validate(bonusNumberString);
        return convertToInteger(bonusNumberString);
    }

    private static int convertToInteger(String bonusNumberString) {
        try {
            return Integer.parseInt(bonusNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
