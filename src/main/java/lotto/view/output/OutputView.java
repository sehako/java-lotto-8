package lotto.view.output;

import lotto.domain.Lottos;
import lotto.dto.response.LottoCalculationResponse;

public interface OutputView {
    void printExceptionMessage(Throwable throwable);

    void printLottoIssueResult(Lottos lottos);

    void printWinningStatistics(LottoCalculationResponse winningStatistics);
}
