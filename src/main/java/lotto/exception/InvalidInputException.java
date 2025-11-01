package lotto.exception;

import lotto.exception.common.ErrorMessage;
import lotto.exception.common.LottoException;

public class InvalidInputException extends LottoException {

    public InvalidInputException(ErrorMessage message) {
        super(message);
    }
}
