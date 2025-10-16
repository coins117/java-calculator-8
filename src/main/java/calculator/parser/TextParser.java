package calculator.parser;

import calculator.domain.Numbers;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextParser {

    private final List<DelimiterStrategy> strategies;

    public TextParser(List<DelimiterStrategy> strategies) {
        this.strategies = strategies;
    }

    public Numbers parse(String input) {
        if (input.isBlank()) {
            return new Numbers(Collections.emptyList());
        }

        DelimiterStrategy strategy = findStrategy(input);
        String delimiter = strategy.extractDelimiter(input);
        String numbersText = strategy.extractNumbersText(input);

        List<Integer> numbers = splitAndConvert(numbersText, delimiter);
        return new Numbers(numbers);
    }

    private DelimiterStrategy findStrategy(String input) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 입력 형식입니다"));
    }

    private List<Integer> splitAndConvert(String numbersText, String delimiter) {
        if (numbersText.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.stream(numbersText.split(delimiter))
                .map(this::toInt)
                .toList();
    }

    private int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("형식이 올바르지 않습니다.", e);
        }
    }
}
