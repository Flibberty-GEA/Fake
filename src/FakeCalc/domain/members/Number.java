package FakeCalc.domain.members;

/**
 * An operand of expression.
 *
 * @author  Yevgen Goliuk
 */
public class Number implements Member {

    private Double value = 0.0;

    public String getValue() {
        return String.valueOf(value);
    }

    public Double getDoubleValue() {
        return value;
    }

    public Number(final String value){
        this.value = Double.valueOf(value);
    }

}
