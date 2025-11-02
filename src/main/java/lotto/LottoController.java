package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.dto.LottoPurchaseInformation;
import lotto.parser.PurchaseInformationParser;
import lotto.parser.WinningNumberParser;
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

    public void run() {
        LottoPurchaseInformation purchaseInformation = inputPurchaseAmount();
        Lottos lottos = issueLottos(purchaseInformation);
        Lotto winningNumbers = inputWinningNumbers();
        String bonusNumber = inputBonusNumber();
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

    private Lottos issueLottos(LottoPurchaseInformation purchaseInformation) {
        Lottos lottos = lottoMachine.issueLottery(purchaseInformation.amount());
        outputView.printLottoIssueResult(lottos);
        return lottos;
    }

    private Lotto inputWinningNumbers() {
        while (true) {
            try {
                String winningNumberInput = inputView.inputWinningNumbers();
                return WinningNumberParser.parse(winningNumberInput);
            } catch (IllegalArgumentException error) {
                outputView.printExceptionMessage(error);
            }
        }
    }

    private String inputBonusNumber() {
        return inputView.inputBonusNumber();
    }
}
