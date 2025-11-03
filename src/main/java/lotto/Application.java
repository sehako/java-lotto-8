package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.WinningStatistics;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        LottoMachine lottoMachine = new LottoMachine();
        WinningStatistics winningStatistics = new WinningStatistics();
        LottoController lottoController = new LottoController(
                inputView,
                outputView,
                lottoMachine,
                winningStatistics
        );

        lottoController.run();
    }
}
