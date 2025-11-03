package lotto.domain.common;

public enum ErrorMessage {

    // input
    INVALID_INPUT("숫자만 입력 가능합니다."),
    ZERO_START_NUMBER("숫자는 0으로 시작할 수 없습니다."),
    NEGATIVE_NUMBER("음수는 입력할 수 없습니다."),

    // purchase
    INVALID_PURCHASE_PRICE("구입금액은 1,000원 단위로 입력해주세요."),
    MAXIMUM_PURCHASE_PRICE_OVER("구입금액은 최대 20억 원까지 입력 가능합니다."),
    INVALID_PURCHASE_PRICE_RANGE("구매금액은 1000부터 20억 사이의 금액을 입력해주세요."),

    // numbers (lotto % bonus)
    NOT_SIX_LOTTO_NUMBERS("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("1에서 45 사이의 숫자만 입력 가능합니다."),
    LOTTO_NUMBER_DUPLICATION("당첨 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_DUPLICATION("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    ;

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, message);
    }
}