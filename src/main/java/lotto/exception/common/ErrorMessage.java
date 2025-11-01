package lotto.exception.common;

public enum ErrorMessage {
    INVALID_INPUT("숫자만 입력 가능합니다."),
    ZERO_START_NUMBER("숫자는 0으로 시작할 수 없습니다.");

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, message);
    }
}