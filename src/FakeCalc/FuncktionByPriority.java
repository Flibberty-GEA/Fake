package FakeCalc;

import FakeCalc.domain.members.symbols.operators.Function;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author Yevgen Goliuk
 */
public class FuncktionByPriority implements Comparator<Function> {
//public static final Logger log = LogManager.getLogger(FuncktionByPriority.class);

    @Override
    public int compare(Function firstFunction, Function secondFunction){

        final int priorityFirstFun = firstFunction.getPriority();

        final int prioritySecondFun = secondFunction.getPriority();

        final int result;

        if (priorityFirstFun < prioritySecondFun) {
            result = 1;
        } else if (priorityFirstFun > prioritySecondFun) {
            result = -1;
        } else {
            result = 0;
        }

        return result;
    }
}
