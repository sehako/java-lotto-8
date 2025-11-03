package lotto.application;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningLottoInformation;
import lotto.dto.request.LottoCalculationRequest;
import lotto.dto.response.LottoCalculationResponse;

public class WinningStatistics {
    private static final double PERCENT_RATE = 100.0;
    private static final int SCALE_FACTOR = 10;

    private static boolean hasWinningMatch(LottoRank rank) {
        return rank != null;
    }

    public LottoCalculationResponse calculateWinningStatistics(
            LottoCalculationRequest request
    ) {
        Lottos issuedLottos = request.issuedLotto();
        WinningLottoInformation winningLottoInformation = request.winningLottoInformation();
        LottoCount lottoCount = request.lottoCount();
        Lotto winningLotto = winningLottoInformation.winningLotto();
        int bonusNumber = winningLottoInformation.bonusNumber();

        Map<LottoRank, Long> statistics = newStatistics();
        for (Lotto lotto : issuedLottos.issuedLottos()) {
            LottoRank rank = lotto.matchRank(winningLotto, bonusNumber);
            writeWinningStatistics(rank, statistics);
        }

        return calculate(statistics, lottoCount);
    }

    private Map<LottoRank, Long> newStatistics() {
        Map<LottoRank, Long> statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0L);
        }

        return statistics;
    }

    private void writeWinningStatistics(LottoRank rank, Map<LottoRank, Long> statistics) {
        if (!hasWinningMatch(rank)) {
            return;
        }

        statistics.merge(rank, 1L, Long::sum);
    }

    private LottoCalculationResponse calculate(
            Map<LottoRank, Long> statistics,
            LottoCount lottoCount
    ) {
        long totalReward = getTotalReward(statistics);
        double returnRate = ((double) totalReward / lottoCount.purchasePrice()) * PERCENT_RATE;
        returnRate = Math.round(returnRate * SCALE_FACTOR) / (double) SCALE_FACTOR;

        return LottoCalculationResponse.of(statistics, returnRate);
    }

    private long getTotalReward(Map<LottoRank, Long> statistics) {
        return statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }
}
