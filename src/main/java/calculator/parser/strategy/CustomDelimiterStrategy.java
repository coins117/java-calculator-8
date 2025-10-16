package calculator.parser.strategy;

import calculator.parser.DelimiterStrategy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterStrategy implements DelimiterStrategy {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    @Override
    public boolean supports(String input) {
        return input.startsWith("//");
    }

    @Override
    public String extractDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return Pattern.quote(matcher.group(1));
        }
        throw new IllegalArgumentException("잘못된 입력 형식입니다");
    }

    @Override
    public String extractNumbersText(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(2);
        }
        throw new IllegalArgumentException("잘못된 입력 형식입니다");
    }
}
