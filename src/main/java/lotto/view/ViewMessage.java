package lotto.view;

public class ViewMessage {
    // InputView
    public static final String PURCHASE_AMOUNT_INPUT_GUIDE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_INPUT_GUIDE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_GUIDE = "보너스 번호를 입력해 주세요.";

    // OutputView
    public static final String LOTTO_ISSUE_COUNT_FORMAT = "%d개를 구매했습니다.";
    public static final String LOTTO_NUMBER_FORMAT = "[%s]";
    public static final String LOTTO_STATISTICS_NOTIFICATION = "당첨 통계";
    public static final String LOTTO_STATISTICS_SEPARATOR = "---";
    public static final String LOTTO_STATISTICS_RETURN_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private ViewMessage() {
        throw new IllegalStateException("Message class");
    }
}
