package lotto.exception.common;

public enum ErrorMessage {
    INVALID_INPUT("숫자만 입력 가능합니다."),
    ZERO_START_NUMBER("숫자는 0으로 시작할 수 없습니다."),
    INVALID_PURCHASE_PRICE("구입금액은 1,000원 단위로 입력해주세요."),
    MAXIMUM_PURCHASE_PRICE_OVER("구입금액은 최대 20억 원까지 입력 가능합니다.");

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, message);
    }
}