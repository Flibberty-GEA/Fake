package FakeCalc.domain.members.symbols;

/**
 * Parentheses in mathematics signify a different precedence of operators.
 *
 * @author  Yevgen Goliuk
 */
public class OpeningBracket extends Symbol {

    private int position = 0;
    private String value = "(";

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean isOperator() {
        return false;
    }
}
