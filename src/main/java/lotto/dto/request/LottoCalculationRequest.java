package lotto.dto.request;

import lotto.domain.Lottos;
import lotto.dto.LottoPurchaseInformation;
import lotto.dto.WinningLottoInformation;

public record LottoCalculationRequest(
        LottoPurchaseInformation purchaseInformation,
        Lottos issuedLotto,
        WinningLottoInformation winningLottoInformation
) {
    public static LottoCalculationRequest of(
            LottoPurchaseInformation purchaseInformation,
            Lottos issuedLotto,
            WinningLottoInformation winningLottoInformation
    ) {
        return new LottoCalculationRequest(purchaseInformation, issuedLotto, winningLottoInformation);
    }
}
