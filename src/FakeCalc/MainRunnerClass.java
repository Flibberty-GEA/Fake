package FakeCalc;

import FakeCalc.domain.members.Member;
import FakeCalc.domain.members.symbols.Symbol;
import jdk.nashorn.internal.runtime.options.Option;

import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Optional;

/**
 * @author Yevgen Goliuk
 */
public class MainRunnerClass {
//public static final Logger log = Lo   gManager.getLogger(MainRunnerClass.class);

    public static void main(String[] args) {
//        String inputString = "2";
        String inputString = "3 - 2";
//        String inputString = "2 + -13 / 3";
//        String inputString = "log ( 2 , 8 )";
//        String inputString = "root ( 2 , 3 )";
//        String inputString = "( 2 )";
//        String inputString = "( 2 + -3 )";
//        String inputString = "( 2 + ( 4 * 3 ) + 4 ) + 3";
//        String inputString = "2 + 4 * 3 + root ( 2 , 3 )";
//        String inputString = "( 2 + 4 ) * 3 + root ( 2 , 3 ) + ( 1 + -7 )";
        Double result = new MyExecutor(inputString).execute();
        System.out.println("RESULT = "+result);
//        printList(Symbol.values());
//        printList(Symbol.descriptions());
    }


    private static void printList(List<String> list) {
        for (String t : list) {
            System.out.println(t);
        }
    }

    private String[] castListSArrey(List<Member> members) {
        String[] result = new String[members.size()];
        for (int j = 0; j < members.size(); j++) {
            result[j] = members.get(j).getValue();
        }
        return result;
    }
}
