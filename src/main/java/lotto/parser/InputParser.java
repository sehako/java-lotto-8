package lotto.parser;

import lotto.validator.LottoNumberValidator;

public class InputParser {

    public static int parsePurchaseAmount(String input) {
        LottoNumberValidator.validateNumber(input);
        LottoNumberValidator.validateNotZeroStart(input);
        return Integer.parseInt(input);
    }
}
