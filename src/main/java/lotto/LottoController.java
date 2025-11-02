package lotto;

import lotto.parser.PurchaseAmountParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int purchaseAmount = inputPurchaseAmount();
    }

    private int inputPurchaseAmount() {
        while (true) {
            String purchaseAmount = inputView.inputPurchaseAmount();
            try {
                return PurchaseAmountParser.parse(purchaseAmount);
            } catch (IllegalArgumentException error) {
                outputView.printExceptionMessage(error);
            }
        }
    }
}
