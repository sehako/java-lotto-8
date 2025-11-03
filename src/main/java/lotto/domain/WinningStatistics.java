package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.dto.LottoCalculationRequest;
import lotto.dto.LottoCalculationResponse;
import lotto.dto.LottoPurchaseInformation;
import lotto.dto.WinningLottoInformation;

public class WinningStatistics {
    private static final double PERCENTAGE_NUMBER = 100.0;

    public LottoCalculationResponse calculateWinningStatistics(
            LottoCalculationRequest request
    ) {
        Lottos issuedLottos = request.issuedLotto();
        WinningLottoInformation winningLottoInformation = request.winningLottoInformation();
        LottoPurchaseInformation purchaseInformation = request.purchaseInformation();
        Lotto winningLotto = winningLottoInformation.winningLotto();
        int bonusNumber = winningLottoInformation.bonusNumber();

        Map<LottoRank, Long> statistics = newStatistics();
        for (Lotto lotto : issuedLottos.lottoList()) {
            LottoRank rank = lotto.matchRank(winningLotto, bonusNumber);
            writeWinningStatistics(rank, statistics);
        }

        return calculate(statistics, purchaseInformation);
    }

    private Map<LottoRank, Long> newStatistics() {
        Map<LottoRank, Long> statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0L);
        }

        return statistics;
    }

    private void writeWinningStatistics(LottoRank rank, Map<LottoRank, Long> statistics) {
        if (LottoRank.NONE == rank) {
            return;
        }

        statistics.merge(rank, 1L, Long::sum);
    }

    private LottoCalculationResponse calculate(
            Map<LottoRank, Long> statistics,
            LottoPurchaseInformation purchaseInformation
    ) {
        long totalReward = getTotalReward(statistics);
        double returnRate = ((double) totalReward / purchaseInformation.price()) * PERCENTAGE_NUMBER;
        returnRate = Math.round(returnRate * 10) / 10.0;

        return LottoCalculationResponse.of(statistics, returnRate);
    }

    private long getTotalReward(Map<LottoRank, Long> statistics) {
        return statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }
}
