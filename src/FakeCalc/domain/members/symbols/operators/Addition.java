package FakeCalc.domain.members.symbols.operators;

import FakeCalc.domain.members.Member;

import java.util.List;

/**
 * @author  Yevgen Goliuk
 */
public class Addition extends Function {

    private String value = "+";
    private int priority = 1;
    private int countOfOperands = 2;
    private int position = 0;

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     *  -1 - Function Operands (before)

     *   0 - Operand Function Operand (between)
     *   1 - Operands Function (after)
     */
    private int association = 0;


    /**
     * @param expression has x - left operand of operation
     *                     y - right operand of operation
     * @return  result of operation
     */
    @Override
    public Double apply(final List<Member> expression) {
        return (Double.valueOf(expression.get(getPositionFirstOperand()).getValue())) + (Double.valueOf(expression.get(getPositionSecondOperand()).getValue()));
    }

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

    public int getPositionFirstOperand(){
        return position-1;
    }
    public int getPositionSecondOperand(){
        return position+1;
    }

}
