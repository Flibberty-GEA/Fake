package FakeCalc;

import FakeCalc.domain.members.Member;
import FakeCalc.domain.members.Number;
import FakeCalc.domain.members.symbols.Symbol;
import FakeCalc.domain.members.symbols.operators.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yevgen Goliuk
 */
public class MainRunnerClass {
//public static final Logger log = LogManager.getLogger(MainRunnerClass.class);

    public static void main(String[] args) {
        List<Member> expression = new ArrayList<>();
        expression.add(0, new Number("17"));
        try {
            expression.add(1, Symbol.createInstance('+', 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        expression.add(2, new Number("3"));

        Double result = ((Function)expression.get(1)).apply(expression);
        System.out.println(result);
    }
}
