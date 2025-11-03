package lotto.view.input.validator;

import static lotto.domain.common.ErrorMessage.INVALID_LOTTO_NUMBER;

public class LottoNumberValidator {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    public static void validate(int number) {
        if (!isValidLottoNumber(number)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return LOTTO_START_NUMBER <= number
                && number <= LOTTO_END_NUMBER;
    }
}
