package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.parser.PurchaseAmountParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            LottoMachine lottoMachine
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        int purchaseAmount = inputPurchaseAmount();
        Lottos lottos = lottoMachine.issueLottery(purchaseAmount / 1000);
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
