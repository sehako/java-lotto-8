package lotto;

import lotto.parser.InputParser;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String purchaseAmount = inputView.inputPurchaseAmount();
        int purchaseAmountNumber = InputParser.parsePurchaseAmount(purchaseAmount);


    }
}
