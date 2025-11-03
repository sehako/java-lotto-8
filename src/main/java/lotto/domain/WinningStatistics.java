package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.dto.LottoCalculationRequest;
import lotto.dto.LottoCalculationResponse;
import lotto.dto.WinningLottoInformation;

public class WinningStatistics {

    public LottoCalculationResponse calculateWinningStatistics(
            LottoCalculationRequest request
    ) {
        Lottos issuedLottos = request.issuedLotto();
        WinningLottoInformation winningLottoInformation = request.winningLottoInformation();
        Lotto winningLotto = winningLottoInformation.winningLotto();
        int bonusNumber = winningLottoInformation.bonusNumber();

        Map<LottoRank, Long> statistics = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : issuedLottos.lottoList()) {
            LottoRank rank = lotto.matchRank(winningLotto, bonusNumber);
            writeWinningStatistics(rank, statistics);
        }

        return LottoCalculationResponse.of(statistics);
    }

    private void writeWinningStatistics(LottoRank rank, Map<LottoRank, Long> statistics) {
        if (LottoRank.NONE == rank) {
            return;
        }

        statistics.merge(rank, rank.getReward(), Long::sum);
    }
}
