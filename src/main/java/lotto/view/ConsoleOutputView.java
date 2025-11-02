package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

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

    private void printNewLine() {
        System.out.println();
    }

    private List<String> convertToStringList(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .toList();
    }
}
