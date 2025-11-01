package lotto.exception;

import lotto.exception.common.ErrorMessage;
import lotto.exception.common.LottoException;

public class InvalidPurchaseAmountException extends LottoException {

    public InvalidPurchaseAmountException(ErrorMessage message) {
        super(message);
    }
}
