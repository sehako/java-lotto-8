package lotto.view;

import static lotto.view.GuideMessage.PURCHASE_AMOUNT_INPUT_GUIDE;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public String inputPurchasePrice() {
        System.out.println(PURCHASE_AMOUNT_INPUT_GUIDE);
        return Console.readLine();
    }
}
