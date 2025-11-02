package lotto.domain;

import static lotto.exception.common.ErrorMessage.LOTTO_NUMBER_DUPLICATION;
import static lotto.exception.common.ErrorMessage.NOT_SIX_LOTTO_NUMBERS;

import java.util.HashSet;
import java.util.List;
import lotto.exception.InvalidLottoNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidLottoNumberException(NOT_SIX_LOTTO_NUMBERS);
        }

        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new InvalidLottoNumberException(LOTTO_NUMBER_DUPLICATION);
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
