package lotto.parser;

import lotto.validator.NumberInputValidator;

public class BonusNumberParser {
    public static int parse(String bonusNumberString) {
        NumberInputValidator.validate(bonusNumberString);
        return Integer.parseInt(bonusNumberString);
    }
}
