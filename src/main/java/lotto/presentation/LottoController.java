package lotto.presentation;

import lotto.application.LottoMachine;
import lotto.application.WinningStatistics;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.dto.WinningLottoInformation;
import lotto.dto.request.LottoCalculationRequest;
import lotto.dto.response.LottoCalculationResponse;
import lotto.view.input.InputView;
import lotto.view.input.parser.BonusNumberParser;
import lotto.view.input.parser.LottoCountParser;
import lotto.view.input.parser.WinningNumberParser;
import lotto.view.output.OutputView;

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
        LottoCount purchaseInformation = inputPurchaseAmount();
        Lottos issuedLottos = issueLottos(purchaseInformation);
        Lotto winningLotto = inputWinningNumbers();
        WinningLottoInformation winningLottoInformation = inputBonusNumber(winningLotto);

        LottoCalculationResponse calculationResult = calculateWinningStatistics(
                purchaseInformation,
                issuedLottos,
                winningLottoInformation
        );

        outputView.printWinningStatistics(calculationResult);

    }

    private LottoCalculationResponse calculateWinningStatistics(
            LottoCount lottoCount,
            Lottos issuedLottos,
            WinningLottoInformation winningLottoInformation
    ) {
        return winningStatistics.calculateWinningStatistics(
                LottoCalculationRequest.of(lottoCount, issuedLottos, winningLottoInformation)
        );
    }

    private Lottos issueLottos(LottoCount lottoCount) {
        Lottos lottos = lottoMachine.issueLottos(lottoCount.amount());
        outputView.printLottoIssueResult(lottos);
        return lottos;
    }

    private LottoCount inputPurchaseAmount() {
        while (true) {
            String purchasePrice = inputView.inputPurchasePrice();
            try {
                return LottoCountParser.parse(purchasePrice);
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
