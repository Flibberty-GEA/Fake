package Parser.symbols;

import Parser.symbols.operators.*;

/**
 * Created by yevgen on 15.12.16.
 */
public class SymbolFactory {

    public Symbol getOperator(Character type) throws Exception {
        switch (type) {
            case '+':
                return new Plus();
            case '-':
                return new Minus();
            case '*':
                return new Multiply();
            case '/':
                return new Divide();
            case '^':
                return new Power();
            case '(':
                return new OpeningBracket();
            case ')':
                return new ClosingBracket();
            default:
                throw new Exception();
        }

    }
}
