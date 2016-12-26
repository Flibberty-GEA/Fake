package FakeCalc;

import FakeCalc.domain.members.Member;
import FakeCalc.domain.members.Number;
import FakeCalc.domain.members.symbols.Symbol;
import FakeCalc.domain.members.symbols.operators.Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yevgen Goliuk
 */
public class MyExecutor {
//public static final Logger log = LogManager.getLogger(MyExecutor.class);

    private String userExpression;

    public MyExecutor(String userExpression) {
        this.userExpression = userExpression;
    }

    public Double execute(){
        List<Member> expression = new ArrayList<>();
        String[] str = userExpression.split(" ");
        System.out.println("Hello from execute()");
        for (String s:str) {
            System.out.println(s);
        }
        Double result = ((Number)parse(str).get(0)).getDoubleValue();
        return result;
    }

    public List<Member> parse(String[] str){
        System.out.println("Hello from parse()");
        List<Member> expression = new ArrayList<>();
//        String[] str = userExpression.split(" ");
        for (String s:str) {
            System.out.println(s);
        }

        for (int i=0;i < str.length;i++) {
            try {
                expression.add(i, new Number(str[i]));
            } catch (Exception e){
                try {
                    expression.add(i, Symbol.createInstance(str[i], i));
                } catch (Exception b){

                }
            }
        }


        System.out.println("\n");
        for (Member m:expression) {
            System.out.println(m.getValue());
        }

        List<Function> functions = new ArrayList<>();

        for (Member item:expression) {
            if (item instanceof Function) functions.add((Function) item);
        }

        System.out.println("\n");
        for (Member f:functions) {
            System.out.println(f.getValue() + " " + f.getClass() + " " + ((Function)f).getPosition());
        }

        Collections.sort(functions, new FuncktionByPriority());

        System.out.println("\n");
        for (Member f:functions) {
            System.out.println(f.getValue() + " " + f.getClass() + " " + ((Function)f).getPosition());
        }

//        Double res = 0d;
//        for (Function function:functions) {
//            expression = function.apply(expression);
//            res = execute();
//        }
        expression = calc(expression, functions);
//        return res;
        return expression;
    }


    public List<Member> calc(List<Member> expression, List<Function> functions){
        System.out.println("Hello from calc()");

            if (functions.size()!=0) {
                expression = functions.get(0).apply(expression);
//                functions.remove(0);
                String[] str = new String[expression.size()];
                for (int i=0;i<expression.size();i++){
                    str[i] = expression.get(i).getValue();
                    System.out.print("new str "+str[i] + " ");
                }
                System.out.println();
                if(functions.size()>1) {
                    expression = parse(str);
                }
            }

        return expression;
    }

}
