package lotto;

import lotto.application.LottoMachine;
import lotto.application.WinningStatistics;
import lotto.presentation.LottoController;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

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

        try {
            lottoController.run();
        } finally {
            lottoController.stop();
        }
    }
}
