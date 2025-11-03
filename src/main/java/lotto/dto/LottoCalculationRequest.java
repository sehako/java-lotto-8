package lotto.dto;

import lotto.domain.Lottos;

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
