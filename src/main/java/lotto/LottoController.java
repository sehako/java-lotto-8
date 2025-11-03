package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningStatistics;
import lotto.dto.LottoCalculationRequest;
import lotto.dto.LottoCalculationResponse;
import lotto.dto.LottoPurchaseInformation;
import lotto.dto.WinningLottoInformation;
import lotto.parser.BonusNumberParser;
import lotto.parser.PurchaseInformationParser;
import lotto.parser.WinningNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;
    private final WinningStatistics winningStatistics;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            LottoMachine lottoMachine,
            WinningStatistics winningStatistics
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
        this.winningStatistics = winningStatistics;
    }

    public void run() {
        LottoPurchaseInformation purchaseInformation = inputPurchaseAmount();
        Lottos issuedLottos = issueLottos(purchaseInformation);
        Lotto winningLotto = inputWinningNumbers();
        WinningLottoInformation winningLottoInformation = inputBonusNumber(winningLotto);

        LottoCalculationResponse calculationResult = calculateWinningStatistics(issuedLottos,
                winningLottoInformation);

    }

    private LottoCalculationResponse calculateWinningStatistics(
            Lottos issuedLottos,
            WinningLottoInformation winningLottoInformation
    ) {
        return winningStatistics.calculateWinningStatistics(
                LottoCalculationRequest.of(issuedLottos, winningLottoInformation)
        );
    }

    private Lottos issueLottos(LottoPurchaseInformation purchaseInformation) {
        Lottos lottos = lottoMachine.issueLottos(purchaseInformation.amount());
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

    private WinningLottoInformation inputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String bonusNumberInput = inputView.inputBonusNumber();
                int bonusNumber = BonusNumberParser.parse(bonusNumberInput);
                return WinningLottoInformation.of(winningLotto, bonusNumber);
            } catch (IllegalArgumentException error) {
                outputView.printExceptionMessage(error);
            }
        }
    }
}
