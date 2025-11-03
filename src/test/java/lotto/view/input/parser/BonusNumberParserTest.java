package lotto.view.input.parser;

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

}