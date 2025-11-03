package lotto.dto;

import lotto.domain.Lottos;

public record LottoCalculationRequest(
        Lottos issuedLotto,
        WinningLottoInformation winningLottoInformation
) {
    public static LottoCalculationRequest of(
            Lottos issuedLotto,
            WinningLottoInformation winningLottoInformation
    ) {
        return new LottoCalculationRequest(issuedLotto, winningLottoInformation);
    }
}
