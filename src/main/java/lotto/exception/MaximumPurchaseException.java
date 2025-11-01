package lotto.exception;

import lotto.exception.common.ErrorMessage;
import lotto.exception.common.LottoException;

public class MaximumPurchaseException extends LottoException {

    public MaximumPurchaseException(ErrorMessage message) {
        super(message);
    }
}
