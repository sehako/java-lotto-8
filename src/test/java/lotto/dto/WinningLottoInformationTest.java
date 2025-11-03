package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLottoInformation;
import lotto.domain.common.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoInformationTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 오류가 발생한다.")
    public void bonusNumberDuplicationTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 3;

        // when
        // then
        Assertions.assertThatThrownBy(() -> WinningLottoInformation.of(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATION.getMessage());
    }
}