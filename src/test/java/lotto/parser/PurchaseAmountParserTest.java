package lotto.parser;

import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.MaximumPurchaseException;
import lotto.exception.common.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

        testExceptionThrownBy(
                input,
                InvalidPurchaseAmountException.class,
                ErrorMessage.INVALID_PURCHASE_PRICE
        );
    }

    @Test
    @DisplayName("사용자가 20억 이상의 구입금액을 입력하면 오류가 발생한다.")
    public void maximumPurchasePriceTest() {
        // given
        String input = "2000000001";

        // when
        // then
        testExceptionThrownBy(
                input,
                MaximumPurchaseException.class,
                ErrorMessage.MAXIMUM_PURCHASE_PRICE_OVER
        );
    }

    private void testExceptionThrownBy(String input, Class<? extends IllegalArgumentException> c,
                                       ErrorMessage errorMessage) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountParser.parse(input))
                .isInstanceOf(c)
                .hasMessage(errorMessage.getMessage());
    }
}