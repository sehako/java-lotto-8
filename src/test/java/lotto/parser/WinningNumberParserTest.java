package lotto.parser;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberParserTest {

    @Test
    @DisplayName("사용자가 당첨 번호를 입력하면 쉽표 기준으로 당첨 로또를 발급한다.")
    public void winningNumberParsingTest() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        Lotto winningLotto = WinningNumberParser.parse(input);

        // then
        Assertions.assertThat(winningLotto.numbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("사용자가 당첨 번호 입력 중 공백을 입력해도 정상적으로 로또가 발급된다.")
    public void winningNumberBlankTest() {
        // given
        String input = "1, 2, 3, 4, 5, 6";

        // when
        Lotto winningLotto = WinningNumberParser.parse(input);

        // then
        Assertions.assertThat(winningLotto.numbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}