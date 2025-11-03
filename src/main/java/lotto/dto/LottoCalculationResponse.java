package lotto.dto;

import java.util.Map;
import lotto.domain.LottoRank;

public record LottoCalculationResponse(
        Map<LottoRank, Long> statistics
) {
    public static LottoCalculationResponse of(Map<LottoRank, Long> statistics) {
        return new LottoCalculationResponse(Map.copyOf(statistics));
    }
}
