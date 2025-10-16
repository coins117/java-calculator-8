package calculator;

import calculator.domain.Numbers;
import calculator.parser.TextParser;

public class TextAdder {

    private final TextParser parser;

    public TextAdder(TextParser parser) {
        this.parser = parser;
    }

    public int add(String input) {
        Numbers numbers = parser.parse(input);
        return numbers.sum();
    }
}
