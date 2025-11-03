package lotto.domain;

import static lotto.domain.common.ErrorMessage.INVALID_PURCHASE_PRICE;

public class LottoCount {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public LottoCount(int purchasePrice) {
        if (!isValidPurchasePrice(purchasePrice)) {
            throw new IllegalArgumentException(INVALID_PURCHASE_PRICE.getMessage());
        }

        amount = purchasePrice / LOTTO_PRICE;
    }

    private static boolean isValidPurchasePrice(int purchasePrice) {
        return purchasePrice >= LOTTO_PRICE && purchasePrice % LOTTO_PRICE == 0;
    }

    public static LottoCount of(int purchasePrice) {
        return new LottoCount(purchasePrice);
    }

    public int amount() {
        return amount;
    }

    public int purchasePrice() {
        return amount * LOTTO_PRICE;
    }
}
