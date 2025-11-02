package lotto.parser;

import static lotto.exception.common.ErrorMessage.INVALID_PURCHASE_PRICE;
import static lotto.exception.common.ErrorMessage.INVALID_PURCHASE_PRICE_RANGE;
import static lotto.exception.common.ErrorMessage.MAXIMUM_PURCHASE_PRICE_OVER;

import lotto.exception.PurchaseAmountException;
import lotto.validator.NumberInputValidator;

public class PurchaseAmountParser {
    private static final int BASIC_PURCHASE_PRICE = 1000;
    private static final int MAX_PURCHASE_PRICE = 2_000_000_000;

    public static int parse(String input) {
        NumberInputValidator.validate(input);

        int purchaseAmount = convertToInteger(input);

        if (!isValidPurchasePrice(purchaseAmount)) {
            throw new PurchaseAmountException(INVALID_PURCHASE_PRICE);
        }

        return purchaseAmount;
    }

    private static int convertToInteger(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);

            if (purchaseAmount > MAX_PURCHASE_PRICE) {
                throw new PurchaseAmountException(MAXIMUM_PURCHASE_PRICE_OVER);
            }

            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new PurchaseAmountException(INVALID_PURCHASE_PRICE_RANGE);
        }
    }

    private static boolean isValidPurchasePrice(int purchaseAmount) {
        return purchaseAmount % BASIC_PURCHASE_PRICE == 0
                && purchaseAmount >= BASIC_PURCHASE_PRICE;
    }
}
