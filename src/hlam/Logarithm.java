package hlam;

/**
 * @author Yevgen Goliuk
 */
public class Logarithm {

//    public static final Logger log = LogManager.getLogger(Function.class);

    private String value = "L";
    private int priority = 3;


    public String getValue() {
        return value;
    }

    /**
     * log a (b) = log c (b) / log c (a)
     *
     * @param operands has x - number 'b'
     *                     y - base 'a'
     * @return  result of operation
     */
    public Double apply(Double... operands) {
        Double b = Math.log10(operands[1]);
        Double a = Math.log10(operands[0]);
        return b / a;
    }

    public boolean isOperator() {
        return true;
    }

    public int getPriority() {
        return priority;
    }
}
