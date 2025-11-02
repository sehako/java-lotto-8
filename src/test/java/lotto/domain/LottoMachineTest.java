package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("사용자가 6000원을 입력하면 6개의 로또가 발급된다.")
    public void issueLottoTest() {
        // given
        int purchaseAmount = 6000;

        // when
        Lottos lottos = lottoMachine.issueLottery(purchaseAmount / 1000);
        // then
        Assertions.assertThat(lottos.lottoList()).hasSize(6);
    }
}