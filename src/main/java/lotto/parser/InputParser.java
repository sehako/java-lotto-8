package lotto.parser;

import lotto.validator.NumberInputValidator;

public class InputParser {

    public static int parsePurchaseAmount(String input) {
        NumberInputValidator.validate(input);
        return Integer.parseInt(input);
    }
}
