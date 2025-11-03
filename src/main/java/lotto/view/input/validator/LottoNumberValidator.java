package lotto.view.input.validator;

import static lotto.exception.common.ErrorMessage.INVALID_LOTTO_NUMBER;

import lotto.exception.InvalidLottoNumberException;

public class LottoNumberValidator {
    public static void validate(int number) {
        if (!isValidLottoNumber(number)) {
            throw new InvalidLottoNumberException(INVALID_LOTTO_NUMBER);
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return 0 < number && number <= 45;
    }
}
