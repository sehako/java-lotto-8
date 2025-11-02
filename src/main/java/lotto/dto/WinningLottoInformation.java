package lotto.dto;

import java.util.HashSet;
import lotto.domain.Lotto;
import lotto.exception.BonusNumberDuplicationException;
import lotto.exception.common.ErrorMessage;

public record WinningLottoInformation(
        Lotto winningLotto,
        int bonusNumber
) {
    public static WinningLottoInformation of(Lotto winningLotto, int bonusNumber) {
        if (new HashSet<>(winningLotto.numbers()).contains(bonusNumber)) {
            throw new BonusNumberDuplicationException(ErrorMessage.BONUS_NUMBER_DUPLICATION);
        }

        return new WinningLottoInformation(winningLotto, bonusNumber);
    }
}
