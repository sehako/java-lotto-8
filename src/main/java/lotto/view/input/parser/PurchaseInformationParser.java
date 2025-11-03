package lotto.view.input.parser;

import static lotto.domain.common.ErrorMessage.INVALID_PURCHASE_PRICE;
import static lotto.domain.common.ErrorMessage.INVALID_PURCHASE_PRICE_RANGE;
import static lotto.domain.common.ErrorMessage.MAXIMUM_PURCHASE_PRICE_OVER;

import lotto.dto.LottoPurchaseInformation;
import lotto.view.input.validator.NumberInputValidator;

public class PurchaseInformationParser {
    private static final int BASIC_PURCHASE_PRICE = 1000;
    private static final int MAX_PURCHASE_PRICE = 2_000_000_000;

    public static LottoPurchaseInformation parse(String input) {
        NumberInputValidator.validate(input);

        int purchaseAmount = convertToInteger(input);

        if (!isValidPurchasePrice(purchaseAmount)) {
            throw new IllegalArgumentException(INVALID_PURCHASE_PRICE.getMessage());
        }

        return LottoPurchaseInformation.of(purchaseAmount);
    }

    private static int convertToInteger(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);

            if (purchaseAmount > MAX_PURCHASE_PRICE) {
                throw new IllegalArgumentException(MAXIMUM_PURCHASE_PRICE_OVER.getMessage());
            }

            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PURCHASE_PRICE_RANGE.getMessage());
        }
    }

    private static boolean isValidPurchasePrice(int purchaseAmount) {
        return purchaseAmount % BASIC_PURCHASE_PRICE == 0
                && purchaseAmount >= BASIC_PURCHASE_PRICE;
    }
}
