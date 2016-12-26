package FakeCalc.domain.members.symbols.operators;

import FakeCalc.domain.members.Member;
import FakeCalc.domain.members.Number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yevgen Goliuk
 */
public class Exponentiation extends Function {
    //public static final Logger log = LogManager.getLogger(Exponentiation.class);

    private String value = "root";
    private int priority = 3;
    private int countOfOperands = 2;
    private int position = 0;


    @Override
    public String getValue() {
        return value;
    }

    @Override
    public List<Member> apply(List<Member> expression) {
        Double x = ((Number)expression.get(getPositionFirstOperand())).getDoubleValue();
        System.out.println("x = "+x);
        Double y = ((Number)expression.get(getPositionSecondOperand())).getDoubleValue();
        System.out.println("y = "+y);
        Double result = Math.pow(x, y);

        List<Member> resultList = new ArrayList<>(expression);
        resultList.remove(getPositionSecondOperand());
        resultList.remove(getPositionFirstOperand());
        resultList.remove(position);
        resultList.add(position, new Number(result.toString()));

        return resultList;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public boolean isOperator() {
        return true;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPositionFirstOperand(){
        return position+1;
    }
    public int getPositionSecondOperand(){
        return position+2;
    }

}
