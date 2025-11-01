package lotto.exception.common;

public class LottoException extends IllegalArgumentException {

    public LottoException(ErrorMessage message) {
        super(message.getMessage());
    }
}
