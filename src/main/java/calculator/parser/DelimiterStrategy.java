package calculator.parser;

public interface DelimiterStrategy {

    boolean supports(String input);

    String extractDelimiter(String input);

    String extractNumbersText(String input);
}
