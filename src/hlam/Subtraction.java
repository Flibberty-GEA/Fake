package hlam;

/**
 * @author  Yevgen Goliuk
 */
public class Subtraction {

    private String value = "-";
    private int priority = 1;

    /**
     * @param operands has x - left operand of operation
     *                     y - right operand of operation
     * @return  result of operation
     */
    public Double apply(Double... operands) {
        return operands[0] - operands[1];
    }

    public String getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isOperator() {
        return true;
    }
}
