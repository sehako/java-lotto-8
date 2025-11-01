package lotto.parser;

import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.common.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1001", "999"})
    @DisplayName("사용자가 1,000원 단위가 아닌 값을 입력하면 오류가 발생한다.")
    public void invalidPurchasePriceTest(String input) {
        // given
        // when
        // then

        Assertions.assertThatThrownBy(() -> PurchaseAmountParser.parse(input))
                .isInstanceOf(InvalidPurchaseAmountException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
    }

}