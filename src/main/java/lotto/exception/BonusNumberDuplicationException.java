package lotto.exception;

import lotto.exception.common.ErrorMessage;
import lotto.exception.common.LottoException;

public class BonusNumberDuplicationException extends LottoException {

    public BonusNumberDuplicationException(ErrorMessage message) {
        super(message);
    }
}
