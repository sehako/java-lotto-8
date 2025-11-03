package lotto.domain;

import static lotto.domain.common.ErrorMessage.BONUS_NUMBER_DUPLICATION;
import static lotto.domain.common.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.HashSet;

public record WinningLottoInformation(
        Lotto winningLotto,
        int bonusNumber
) {
    private static final int MAX_BONUS_NUMBER = 45;
    private static final int MIN_BONUS_NUMBER = 1;

    public static WinningLottoInformation of(Lotto winningLotto, int bonusNumber) {
        if (new HashSet<>(winningLotto.numbers()).contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION.getMessage());
        }

        if (bonusNumber < MIN_BONUS_NUMBER || MAX_BONUS_NUMBER < bonusNumber) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        return new WinningLottoInformation(winningLotto, bonusNumber);
    }
}
