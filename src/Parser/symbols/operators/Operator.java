package Parser.symbols.operators;

import Parser.symbols.Symbol;

/**
 * Created by yevgen on 15.12.16.
 */
public abstract class Operator extends Symbol {
    public abstract Double apply(final Double x, final Double y);
}
