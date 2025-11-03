package lotto.view.output;

import static lotto.view.ViewMessage.LOTTO_ISSUE_COUNT_FORMAT;
import static lotto.view.ViewMessage.LOTTO_NUMBER_FORMAT;
import static lotto.view.ViewMessage.LOTTO_STATISTICS_NOTIFICATION;
import static lotto.view.ViewMessage.LOTTO_STATISTICS_RETURN_RATE_FORMAT;
import static lotto.view.ViewMessage.LOTTO_STATISTICS_SEPARATOR;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.dto.response.LottoCalculationResponse;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printExceptionMessage(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void printLottoIssueResult(Lottos lottos) {
        printNewLine();
        String totalLottoCount = String.format(LOTTO_ISSUE_COUNT_FORMAT, lottos.getAmount());
        System.out.println(totalLottoCount);

        for (Lotto issuedLotto : lottos.issuedLottos()) {
            String lottoNumber = String.format(LOTTO_NUMBER_FORMAT, issuedLotto.getNumbersAsString());
            System.out.println(lottoNumber);
        }

        printNewLine();
    }

    @Override
    public void printWinningStatistics(LottoCalculationResponse winningStatistics) {
        Map<LottoRank, Long> statistics = winningStatistics.statistics();

        System.out.println(LOTTO_STATISTICS_NOTIFICATION);
        System.out.println(LOTTO_STATISTICS_SEPARATOR);

        for (LottoRank rank : LottoRank.values()) {
            System.out.println(rank.formattedDescription(statistics.get(rank)));
        }

        String returnRateString = String.format(
                LOTTO_STATISTICS_RETURN_RATE_FORMAT, winningStatistics.returnRate()
        );

        System.out.println(returnRateString);
    }

    private void printNewLine() {
        System.out.println();
    }
}
