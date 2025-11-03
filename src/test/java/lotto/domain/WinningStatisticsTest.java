package lotto.domain;

import static lotto.domain.LottoRank.FIFTH;
import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.FOURTH;
import static lotto.domain.LottoRank.NONE;
import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoCalculationRequest;
import lotto.dto.LottoCalculationResponse;
import lotto.dto.LottoPurchaseInformation;
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
        LottoPurchaseInformation information = LottoPurchaseInformation.of(8000);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        Lottos issuedLottos = new Lottos(lottos);
        WinningLottoInformation winningLottoInformation = WinningLottoInformation.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );

        // when
        LottoCalculationResponse response = winningStatistics.calculateWinningStatistics(
                LottoCalculationRequest.of(information, issuedLottos, winningLottoInformation)
        );

        // then
        Assertions.assertThat(response.statistics())
                .containsExactlyInAnyOrderEntriesOf(Map.of(
                        FIRST, 0L,
                        SECOND, 0L,
                        THIRD, 0L,
                        FOURTH, 0L,
                        FIFTH, 1L,
                        NONE, 0L
                ));

        Assertions.assertThat(response.returnRate()).isEqualTo(62.5);
    }
}