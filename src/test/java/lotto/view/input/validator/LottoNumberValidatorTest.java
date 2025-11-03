package lotto.view.input.validator;


import lotto.domain.common.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("사용자가 1부터 45 사이의 로또 번호가 아닌 다른 번호를 입력하면 오류가 발생한다.")
    public void invalidLottoNumberTest(int lottoNumber) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> LottoNumberValidator.validate(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
    }
}