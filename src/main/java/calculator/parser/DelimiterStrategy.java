package calculator.parser;

public interface DelimiterStrategy {

    String CUSTOM_DELIMITER_PREFIX = "//";

    boolean supports(String input);

    String extractDelimiter(String input);

    String extractNumbersText(String input);
}
