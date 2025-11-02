package lotto.parser;

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

        testExceptionThrownBy(input, ErrorMessage.INVALID_PURCHASE_PRICE);
    }

    @Test
    @DisplayName("사용자가 20억 이상의 구입금액을 입력하면 오류가 발생한다.")
    public void maximumPurchasePriceTest() {
        // given
        String input = "2000000001";

        // when
        // then
        testExceptionThrownBy(input, ErrorMessage.MAXIMUM_PURCHASE_PRICE_OVER);
    }

    @Test
    @DisplayName("사용자가 int 범위를 초과한 구입금액을 입력하면 오류가 발생한다.")
    public void invalidPurchaseRangeTest() {
        // given
        String input = "2147483648";
        // when
        // then
        testExceptionThrownBy(input, ErrorMessage.INVALID_PURCHASE_PRICE_RANGE);
    }

    private void testExceptionThrownBy(String input, ErrorMessage errorMessage) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getMessage());
    }
}