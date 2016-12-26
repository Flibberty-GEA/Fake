package FakeCalc.domain.members.symbols.operators;

import FakeCalc.domain.members.Member;
import FakeCalc.domain.members.Number;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @author  Yevgen Goliuk
 */
public class Addition extends Function {

    private String value = "+";
    private int priority = 1;
    private int countOfOperands = 2;
    private int position = 0;

    public int getPosition() {
        return position;
    }

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
    public List<Member> apply(final List<Member> expression) {
        Double x = ((Number)expression.get(getPositionFirstOperand())).getDoubleValue();
//        System.out.println("x = "+x);
        Double y = ((Number)expression.get(getPositionSecondOperand())).getDoubleValue();
//        System.out.println("y = "+y);
        Double result =  (x + y);

        List<Member> resultList = new ArrayList<>(expression);
        resultList.remove(getPositionSecondOperand());
        resultList.remove(position);
        resultList.remove(getPositionFirstOperand());
        resultList.add(getPositionFirstOperand(), new Number(result.toString()));

        return resultList;

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
