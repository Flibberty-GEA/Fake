package FakeCalc.domain.members.symbols.operators;


import FakeCalc.domain.members.Member;
import FakeCalc.domain.members.symbols.Symbol;

import java.util.List;

/**
 * Function is a calculation from zero or more input values (called operands) to an output value.
 *
 * @author  Yevgen Goliuk
 */
public abstract class Function extends Symbol {
    /**
     * @param expression
     * @return  result of operation
     */
    public abstract List<Member> apply(final List<Member> expression);
    public abstract int getPosition();
    public abstract void setPosition(int position);

}
