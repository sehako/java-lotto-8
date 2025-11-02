package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.dto.LottoPurchaseInformation;
import lotto.parser.PurchaseInformationParser;
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
        LottoPurchaseInformation purchaseInformation = inputPurchaseAmount();
        Lottos lottos = issueLottos(purchaseInformation);
        String winningNumbers = inputWinningNumbers();
    }

    private String inputWinningNumbers() {
        return inputView.inputWinningNumbers();
    }

    private Lottos issueLottos(LottoPurchaseInformation purchaseInformation) {
        Lottos lottos = lottoMachine.issueLottery(purchaseInformation.amount());
        outputView.printLottoIssueResult(lottos);
        return lottos;
    }

    private LottoPurchaseInformation inputPurchaseAmount() {
        while (true) {
            String purchasePrice = inputView.inputPurchasePrice();
            try {
                return PurchaseInformationParser.parse(purchasePrice);
            } catch (IllegalArgumentException error) {
                outputView.printExceptionMessage(error);
            }
        }
    }
}
