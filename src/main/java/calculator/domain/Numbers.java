package calculator.domain;

import java.util.List;

public class Numbers {

    private static final int RESULT_WHEN_EMPTY = 0;

    private final List<Integer> values;

    public Numbers(List<Integer> values) {
        validate(values);
        this.values = List.copyOf(values);
    }

    private void validate(List<Integer> numbers) {
        numbers.forEach(this::validatePositive);
    }

    private void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다");
        }
    }

    public int sum() {
        return values.stream()
                .reduce(Integer::sum)
                .orElse(RESULT_WHEN_EMPTY);
    }
}
