package Parser.symbols.operators;

import Parser.symbols.Symbol;

/**
 * Created by yevgen on 15.12.16.
 */
public class Minus extends Operator {
    private String value = "-";
    private int priority = 1;
    @Override
    public String getValue() {
        return value;
    }
    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public boolean isOperator() {
        return true;
    }

    @Override
    public Double apply(final Double x, final Double y) {
        return x - y;
    }


}
