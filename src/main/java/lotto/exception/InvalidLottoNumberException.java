package lotto.exception;

import lotto.exception.common.ErrorMessage;
import lotto.exception.common.LottoException;

public class InvalidLottoNumberException extends LottoException {

    public InvalidLottoNumberException(ErrorMessage message) {
        super(message);
    }
}
