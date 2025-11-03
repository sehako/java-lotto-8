package lotto.view.input.parser;

import lotto.domain.common.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberParserTest {
    @Test
    @DisplayName("사용자가 올바른 보너스 번호를 입력하면 int형으로 변환된다.")
    public void parseBonusNumberTest() {
        // given
        String input = "3";

        // when
        int bonusNumber = BonusNumberParser.parse(input);
        // then
        Assertions.assertThat(bonusNumber).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자가 1 ~ 45 사이가 아닌 보너스 번호를 입력하면 오류가 발생한다.")
    public void invalidBonusNumberInputTest() {
        // given
        String input = "46";

        // when
        // then
        Assertions.assertThatThrownBy(() -> BonusNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
    }
}