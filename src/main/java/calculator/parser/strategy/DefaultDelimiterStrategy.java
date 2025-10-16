package calculator.parser.strategy;

import calculator.parser.DelimiterStrategy;

public class DefaultDelimiterStrategy implements DelimiterStrategy {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    @Override
    public boolean supports(String input) {
        return !input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    @Override
    public String extractDelimiter(String input) {
        return DEFAULT_DELIMITER_REGEX;
    }

    @Override
    public String extractNumbersText(String input) {
        return input;
    }
}
