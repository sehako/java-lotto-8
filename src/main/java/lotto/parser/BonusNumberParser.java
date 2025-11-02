package lotto.parser;

import lotto.exception.InvalidInputException;
import lotto.exception.common.ErrorMessage;
import lotto.validator.LottoNumberValidator;
import lotto.validator.NumberInputValidator;

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
            throw new InvalidInputException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
    }
}
