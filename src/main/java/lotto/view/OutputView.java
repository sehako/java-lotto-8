package lotto.view;

import lotto.domain.Lottos;
import lotto.dto.LottoCalculationResponse;

public interface OutputView {
    void printExceptionMessage(Throwable throwable);

    void printLottoIssueResult(Lottos lottos);

    void printWinningStatistics(LottoCalculationResponse winningStatistics);
}
