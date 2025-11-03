package lotto.exception.common;

import lotto.domain.common.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorMessageTest {

    @Test
    @DisplayName("에러 메시지는 [ERRROR] 접두사가 붙어서 출력된다.")
    public void errorMessageTest() {
        // given
        ErrorMessage errorMessage = ErrorMessage.INVALID_INPUT;
        // when
        // then
        Assertions.assertThat(errorMessage.getMessage())
                .startsWith("[ERROR]");
        Assertions.assertThat(errorMessage.getMessage())
                .isEqualTo("[ERROR] 숫자만 입력 가능합니다.");
    }
}