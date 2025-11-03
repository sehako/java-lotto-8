package lotto.domain;

import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoCalculationRequest;
import lotto.dto.LottoCalculationResponse;
import lotto.dto.WinningLottoInformation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {
    WinningStatistics winningStatistics = new WinningStatistics();

    @Test
    @DisplayName("발급한 로또와 당첨 번호 및 보너스 번호를 비교하여 통계를 계산한다.")
    public void lottoStatisticTest() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );

        Lottos issuedLottos = new Lottos(lottos);
        WinningLottoInformation winningLottoInformation = WinningLottoInformation.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );

        // when
        LottoCalculationResponse response = winningStatistics.calculateWinningStatistics(
                LottoCalculationRequest.of(issuedLottos, winningLottoInformation)
        );

        // then
        Assertions.assertThat(response.statistics())
                .containsExactlyInAnyOrderEntriesOf(Map.of(
                        FIRST, FIRST.getReward() * 2,
                        SECOND, SECOND.getReward(),
                        THIRD, THIRD.getReward()
                ));
    }
}