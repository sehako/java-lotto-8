package lotto.view;

import static lotto.view.message.GuideMessage.BONUS_NUMBER_INPUT_GUIDE;
import static lotto.view.message.GuideMessage.PURCHASE_AMOUNT_INPUT_GUIDE;
import static lotto.view.message.GuideMessage.WINNING_NUMBERS_INPUT_GUIDE;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public String inputPurchasePrice() {
        System.out.println(PURCHASE_AMOUNT_INPUT_GUIDE);
        return Console.readLine();
    }

    @Override
    public String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE);
        return Console.readLine();
    }

    @Override
    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_GUIDE);
        return Console.readLine();
    }
}
