package lotto;

import lotto.view.ConsoleInputView;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        LottoController lottoController = new LottoController(inputView);

        lottoController.start();
    }
}
