package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.exception.InvalidLottoNumberException;
import lotto.exception.common.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new InvalidLottoNumberException(ErrorMessage.LOTTO_NUMBER_DUPLICATION);
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> numbers() {
        return List.copyOf(numbers);
    }
}
