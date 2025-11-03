package lotto.dto.request;

import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.dto.WinningLottoInformation;

public record LottoCalculationRequest(
        LottoCount lottoCount,
        Lottos issuedLotto,
        WinningLottoInformation winningLottoInformation
) {
    public static LottoCalculationRequest of(
            LottoCount lottoCount,
            Lottos issuedLotto,
            WinningLottoInformation winningLottoInformation
    ) {
        return new LottoCalculationRequest(lottoCount, issuedLotto, winningLottoInformation);
    }
}
