package lotto.exception.common;

public enum ErrorMessage {
    INVALID_INPUT("숫자만 입력 가능합니다.");

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, message);
    }
}