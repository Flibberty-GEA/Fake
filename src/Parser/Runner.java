package Parser;

import Parser.symbols.ClosingBracket;
import Parser.symbols.Symbol;
import Parser.symbols.SymbolFactory;
import Parser.symbols.operators.Operator;
import org.reflections.Reflections;
import sun.rmi.transport.proxy.CGIHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by yevgen on 15.12.16.
 */
public class Runner {
//    public static void main(String[] args) {
//        ParserRPN parserRPN = new ParserRPN();
////        String input = "2+0";
//        String input = "(-31)+27*(3/(14-56))^(-2)";
//        try{
//            String output = parserRPN.toRPN(input);
//            System.out.println(output);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {

//        ParserRPN parserRPN = new ParserRPN();
////        String input = "2+0";
//        String input = "(-31)+27*(3/(14-56))^(-2)";
//        try{
//            String output = parserRPN.toRPN(input);
//            System.out.println(output);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        Calculator calculator = new Calculator();
//        String input = "2+0";
        String input = "(-31)+27*(3/(14-56))^(-2)";
        try{
            Double output = calculator.calculate(input);
            System.out.println(output);
        }catch (Exception e){
            e.printStackTrace();
        }

//    GET -> 2+0
//    RETURN -> 2 0 +

//    GET -> (-31)+27*(3/(14-56))^(-2)
//        -> (0-31)+27*(3/(14-56))^(0-2)
//    RETURN -> 0  31 - 27  3  14  56 - /  0  2 - ^ * +
//    RESULT -> 5261.000000000001

//    GET -> (-31)+27*(3+(14-56))*(-2)
//    CHG -> (0-31)+27*(3+(14-56))*(0-2)
//    RETURN -> 0  31 - 27  3  14  56 - + *   0  2 - * +


//        SymbolFactory factory = new SymbolFactory();
//        try {
//            Symbol symbol = factory.getOperator('&');
//            System.out.println("Value -> " + symbol.getValue() +
//                    "\nIs operator? 1-> " + symbol.isOperator() +
//                    "\nIs operator? 2-> " + (symbol instanceof Operator) +
//                    "\nPriority 1-> " + symbol.getPriority());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        Reflections reflections = new Reflections("");
//        Set<Class<? extends Symbol>> subTypes = reflections.getSubTypesOf(Symbol.class);
//        Set<Character> values = new HashSet<>();
//        for (Class clazz:subTypes) {
//            Symbol s = null;
//            try {
//                s = (Symbol)clazz.newInstance();
//                values.add(s.getValue());
//            } catch (InstantiationException e) {
//            } catch (IllegalAccessException e) {
//            }
//            System.out.println(clazz);
//        }
//
//        System.out.println(values);



//String path = "Parser.symbols.operators.";
//        try {
//            Symbol c = (Symbol)Class.forName(path+"Minus").newInstance();
//            System.out.println(c.getValue());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//    Object obj = c.newInstance();
//    Test test = (Test) obj;


//        Character ch = '-';
//        List<Symbol> list = Symbol.values();
//        System.out.println(list);

    }
}
