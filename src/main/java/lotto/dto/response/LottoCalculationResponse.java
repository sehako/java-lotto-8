package lotto.dto.response;

import java.util.Map;
import lotto.domain.LottoRank;

public record LottoCalculationResponse(
        Map<LottoRank, Long> statistics,
        double returnRate
) {

    public static LottoCalculationResponse of(Map<LottoRank, Long> statistics, double returnRate) {
        return new LottoCalculationResponse(Map.copyOf(statistics), returnRate);
    }
}
