package Parser.symbols.operators;

/**
 * Created by yevgen on 15.12.16.
 */
public class Minus extends Operator {
    private Character value = '-';
    private int priority = 1;

    public Character getValue() {
        return value;
    }

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
