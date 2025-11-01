package lotto.exception;

import lotto.exception.common.ErrorMessage;
import lotto.exception.common.LottoException;

public class ZeroStartException extends LottoException {

    public ZeroStartException(ErrorMessage message) {
        super(message);
    }
}
