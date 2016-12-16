package Parser.symbols;

import Parser.symbols.operators.*;
import org.reflections.Reflections;

import java.util.*;

/**
 * Created by yevgen on 15.12.16.
 */
public class SymbolFactory {
    public Symbol getOperator(Character type) throws Exception {
        return null;
//        Reflections reflections = new Reflections("");
//        Set<Class<? extends Symbol>> subTypes = reflections.getSubTypesOf(Symbol.class);
//        Map<Character, Class> values = new HashMap<>();
//        for (Class clazz:subTypes) {
//            Symbol s = null;
//            try {
//                s = (Symbol)clazz.newInstance();
//                values.put(s.getValue(), clazz);
//            } catch (InstantiationException e) {
//            } catch (IllegalAccessException e) {
//            }
//        }
//       if (values.containsKey(type)){
//        try {
//            Class clazz = values.get(type);
//            Symbol c = (Symbol)clazz.newInstance();
//            return c;
//        } catch (Exception e) {
//            throw new Exception();
//        }
//       } else throw new Exception();

//        switch (type) {
//            case '+':
//                return new Plus();
//            case '-':
//                return new Minus();
//            case '*':
//                return new Multiply();
//            case '/':
//                return new Divide();
//            case '^':
//                return new Power();
//            case '(':
//                return new OpeningBracket();
//            case ')':
//                return new ClosingBracket();
//            default:
//                throw new Exception();
//        }
        }
}

