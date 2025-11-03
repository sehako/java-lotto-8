package lotto.domain;

import static lotto.domain.common.ErrorMessage.BONUS_NUMBER_DUPLICATION;

import java.util.HashSet;

public record WinningLottoInformation(
        Lotto winningLotto,
        int bonusNumber
) {
    public static WinningLottoInformation of(Lotto winningLotto, int bonusNumber) {
        if (new HashSet<>(winningLotto.numbers()).contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION.getMessage());
        }

        return new WinningLottoInformation(winningLotto, bonusNumber);
    }
}
