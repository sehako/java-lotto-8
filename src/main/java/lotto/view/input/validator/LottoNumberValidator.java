package lotto.view.input.validator;

import static lotto.exception.common.ErrorMessage.INVALID_LOTTO_NUMBER;

import lotto.exception.InvalidLottoNumberException;

public class LottoNumberValidator {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    public static void validate(int number) {
        if (!isValidLottoNumber(number)) {
            throw new InvalidLottoNumberException(INVALID_LOTTO_NUMBER);
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return LOTTO_START_NUMBER <= number
                && number <= LOTTO_END_NUMBER;
    }
}
