package lotto.parser;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoParserTest {

    @Test
    @DisplayName("사용자가 당첨 번호를 입력하면 쉽표 기준으로 당첨 로또를 발급한다.")
    public void winningNumberParsingTest() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        Lotto winningLotto = WinningLottoParser.parse(input);

        // then
        Assertions.assertThat(winningLotto.numbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

}