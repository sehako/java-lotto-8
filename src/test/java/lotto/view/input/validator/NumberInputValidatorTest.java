package lotto.view.input.validator;

import static lotto.domain.common.ErrorMessage.INVALID_INPUT;
import static lotto.domain.common.ErrorMessage.NEGATIVE_NUMBER;
import static lotto.domain.common.ErrorMessage.ZERO_START_NUMBER;

import lotto.domain.common.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberInputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"이만원", "사십", "2십사", ""})
    @DisplayName("사용자가 숫자가 아닌 값을 입력하면 오류가 발생한다.")
    public void invalidInputTest(String input) {
        // given

        // when
        // then
        testExceptionThrownBy(input, INVALID_INPUT);
    }

    @Test
    @DisplayName("사용자가 0으로 시작하는 값을 입력하면 오류가 발생한다.")
    public void zeroStartNumberInputTest() {
        // given
        String input = "012345";

        // when
        // then
        testExceptionThrownBy(input, ZERO_START_NUMBER);
    }

    @Test
    @DisplayName("사용자가 음수를 입력하면 오류가 발생한다.")
    public void negativeInputTest() {
        // given
        String input = "-12345";

        // when
        // then
        testExceptionThrownBy(input, NEGATIVE_NUMBER);
    }

    private void testExceptionThrownBy(String input, ErrorMessage errorMessage) {
        Assertions.assertThatThrownBy(() -> NumberInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getMessage());
    }
}