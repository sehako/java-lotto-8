package lotto.exception;

import lotto.exception.common.ErrorMessage;
import lotto.exception.common.LottoException;

public class PurchaseAmountException extends LottoException {

    public PurchaseAmountException(ErrorMessage message) {
        super(message);
    }
}
