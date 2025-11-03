package lotto.view.input.parser;

import static lotto.domain.common.ErrorMessage.INVALID_LOTTO_NUMBER;

import lotto.view.input.validator.LottoNumberValidator;
import lotto.view.input.validator.NumberInputValidator;

public class BonusNumberParser {
    public static int parse(String bonusNumberString) {
        NumberInputValidator.validate(bonusNumberString);
        int bonusNumber = convertToInteger(bonusNumberString);
        LottoNumberValidator.validate(bonusNumber);
        return bonusNumber;
    }

    private static int convertToInteger(String bonusNumberString) {
        try {
            return Integer.parseInt(bonusNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }
}
