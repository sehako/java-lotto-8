package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.dto.response.LottoCalculationResponse;

public class ConsoleOutputView implements OutputView {
    private static final String LOTTO_ISSUE_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    @Override
    public void printExceptionMessage(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void printLottoIssueResult(Lottos lottos) {
        printNewLine();
        String totalLottoCount = String.format(LOTTO_ISSUE_COUNT_FORMAT, lottos.getAmount());
        System.out.println(totalLottoCount);

        for (Lotto lotto : lottos.lottoList()) {
            System.out.print("[");

            String lottoNumbers = String.join(
                    LOTTO_NUMBER_DELIMITER,
                    convertToStringList(lotto.numbers())
            );

            System.out.print(lottoNumbers);
            System.out.print("]\n");
        }

        System.out.println();
    }

    @Override
    public void printWinningStatistics(LottoCalculationResponse winningStatistics) {
        Map<LottoRank, Long> statistics = winningStatistics.statistics();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", statistics.get(LottoRank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", statistics.get(LottoRank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", statistics.get(LottoRank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", statistics.get(LottoRank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", statistics.get(LottoRank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.", winningStatistics.returnRate());
    }

    private void printNewLine() {
        System.out.println();
    }

    private List<String> convertToStringList(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .toList();
    }
}
