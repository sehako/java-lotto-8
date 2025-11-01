package lotto.parser;

import static lotto.exception.common.ErrorMessage.INVALID_PURCHASE_PRICE;

import lotto.exception.InvalidPurchaseAmountException;
import lotto.validator.NumberInputValidator;

public class InputParser {
    private static final int BASIC_PURCHASE_PRICE = 1000;

    public static int parsePurchaseAmount(String input) {
        NumberInputValidator.validate(input);

        int purchaseAmount = Integer.parseInt(input);

        if (!isValidPurchasePrice(purchaseAmount)) {
            throw new InvalidPurchaseAmountException(INVALID_PURCHASE_PRICE);
        }

        return purchaseAmount;
    }

    private static boolean isValidPurchasePrice(int purchaseAmount) {
        return purchaseAmount % BASIC_PURCHASE_PRICE == 0
                && purchaseAmount >= BASIC_PURCHASE_PRICE;
    }
}
