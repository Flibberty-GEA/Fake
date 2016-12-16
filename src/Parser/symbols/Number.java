package Parser.symbols;

/**
 * Created by yevgen on 16.12.16.
 */
public class Number implements Mom{

    private Double value = 0.0;

    public String getValue() {
        return String.valueOf(value);
    }

    public Double getDoubleValue() {
        return value;
    }

//    public int getPriority() {
//        return 0;
//    }

//    public boolean isOperator() {
//        return false;
//    }

    public Number(String value){
        this.value = Double.valueOf(value);
    }
}
