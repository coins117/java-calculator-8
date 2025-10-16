package calculator;

import calculator.parser.strategy.CustomDelimiterStrategy;
import calculator.parser.strategy.DefaultDelimiterStrategy;
import calculator.parser.DelimiterStrategy;
import calculator.parser.TextParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        TextAdder textAdder = createTextAdder();
        OutputView outputView = new OutputView();

        run(inputView, textAdder, outputView);
    }

    private static TextAdder createTextAdder() {
        List<DelimiterStrategy> strategies = List.of(
                new CustomDelimiterStrategy(),
                new DefaultDelimiterStrategy()
        );
        TextParser parser = new TextParser(strategies);
        return new TextAdder(parser);
    }

    private static void run(InputView inputView, TextAdder textAdder, OutputView outputView) {
        String input = inputView.readInput();
        int result = textAdder.add(input);
        outputView.print(result);
    }
}
