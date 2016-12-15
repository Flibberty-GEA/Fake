package Parser;

/**
 *
 */
public enum OperatortTempl implements Comparable<OperatortTempl> {

    /**
     * OperatortTempl of the power
     */
    POWER("^") {
        Double apply(final Double x, final Double y) {
            return Math.pow(x, y);
        }

        String regEx() {
            return "\\" + toString();
        }
    },

    /**
     * Division operator
     */
    DIVIDE("/") {
        Double apply(final Double x, final Double y) {
            return x / y;
        }

        String regEx() {
            return "\\" + toString();
        }
    },

    /**
     * Multiply operator
     */
    MULTIPLY("*") {
        Double apply(final Double x, final Double y) {
            return x * y;
        }

        String regEx() {
            return "\\" + toString();
        }
    },

    /**
     * OperatortTempl of the difference
     */
    MINUS("-") {
        Double apply(final Double x, final Double y) {
            return x - y;
        }

        String regEx() {
            return "\\" + toString();
        }
    },

    /**
     * Addition operator
     */
    PLUS("+") {
        Double apply(final Double x, final Double y) {
            return x + y;
        }

        String regEx() {
            return "\\" + toString();
        }
    };

    /**
     * Regular expression of all operators
     */
    public static final String REGEX_ALL;

    /* building of regular expression of all operators */
    static {
        StringBuilder builder = new StringBuilder();
        for (OperatortTempl operatortTempl : OperatortTempl.values()) {
            builder.append(operatortTempl.regEx());
        }
        REGEX_ALL = builder.toString();
    }

    /**
     * String representation of the operator
     */
    private final String symbols;

    /**
     * Initialize a String representation of the operator
     */
    OperatortTempl(final String symbols) {
        this.symbols = symbols;
    }

    /**
     * @return a string representation of the operator
     */
    @Override
    public String toString() {
        return symbols;
    }

    /**
     * @return regular expression of current operator
     */
    abstract String regEx();

    /**
     * @param x left operand of operation
     * @param y right operand of operation
     * @return  result of operation
     */
    abstract Double apply(final Double x, final Double y);
}
