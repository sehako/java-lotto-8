package lotto.dto;

public record LottoPurchaseInformation(
        int price,
        int amount
) {
    private static final int PRICE_UNIT = 1000;

    public static LottoPurchaseInformation of(int price) {
        return new LottoPurchaseInformation(price, price / PRICE_UNIT);
    }
}
