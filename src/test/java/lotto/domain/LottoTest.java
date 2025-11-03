package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.common.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

class LottoTest {

    static List<List<Integer>> invalidLottoNumbers = List.of(
            List.of(0, 1, 2, 3, 4, 5),
            List.of(1, 2, 3, 4, 5, 46)
    );

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @FieldSource("invalidLottoNumbers")
    @DisplayName("사용자가 1부터 45 사이의 로또 번호가 아닌 다른 번호를 입력하면 오류가 발생한다.")
    public void invalidLottoNumberTest(List<Integer> lottoNumber) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

}
