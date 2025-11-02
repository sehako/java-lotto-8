package lotto.view;

import lotto.domain.Lottos;

public interface OutputView {
    void printExceptionMessage(Throwable throwable);

    void printLottoIssueResult(Lottos lottos);
}
