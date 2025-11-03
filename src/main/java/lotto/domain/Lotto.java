package lotto.domain;

import static lotto.domain.common.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.domain.common.ErrorMessage.LOTTO_NUMBER_DUPLICATION;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private static void validateLottoNumberUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION.getMessage());
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (LOTTO_START_NUMBER > number || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        });
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberUnique(numbers);
        validateLottoNumberRange(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public LottoRank matchRank(Lotto lotto, int bonusNumber) {
        int count = (int) numbers.stream()
                .filter(lotto.numbers()::contains)
                .count();

        if (isMatchFiveNumbers(count)) {
            return LottoRank.from(count, numbers.contains(bonusNumber));
        }

        return LottoRank.from(count, false);
    }

    private boolean isMatchFiveNumbers(int count) {
        return count == 5;
    }

    public List<Integer> numbers() {
        return List.copyOf(numbers);
    }

    public String getNumbersAsString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
    }
}
