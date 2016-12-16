package Parser;

import Command.exceptions.InputExpressionException;
import Parser.symbols.*;
import Parser.symbols.Number;
//import Parser.symbols.SymbolFactory;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Created by yevgen on 15.12.16.
 */
public class ParserRPN {

//    SymbolFactory factory = new SymbolFactory();

    /**
     * Convert user's expression in Reverse Polish notation (RPN).
     * Reverse Polish notation (RPN) is a mathematical notation
     * in which every operator follows all of its operands.
     * It is also known as postfix notation and does not need any parentheses
     * as long as each operator has a fixed number of operands.
     * @param userExpression - request user for expression
     * @return resultExpression - output string in RPN
     */
    public Deque<Mom> toRPN(String userExpression) throws Exception {

//        System.out.println(userExpression);

        Deque<Symbol> serviceSymbolStack = new ArrayDeque<>();
        Deque<Mom> resultExpression = new ArrayDeque<>();
        StringBuilder resultExpressionString = new StringBuilder("");
        Symbol serviceSymbol;
        Symbol symbolCurrent;
        char currentSymbol;
        if ((userExpression.trim().charAt(0)=='-') || (userExpression.trim().charAt(0)=='+')) userExpression="0"+userExpression;
        if (userExpression.contains("(-")) userExpression=userExpression.replace("(-", "(0-");

        for (int i = 0; i < userExpression.length(); i++) {
            currentSymbol = userExpression.charAt(i);
            try{
                symbolCurrent = Symbol.createInstance(currentSymbol);
                try{
                    resultExpression.push(new Number(resultExpressionString.toString()));
                    resultExpressionString = new StringBuilder("");
                }catch (Exception e){
                }
                if (symbolCurrent.isOperator()) {
                    while (serviceSymbolStack.size() > 0) {
                        serviceSymbol = serviceSymbolStack.peek();
                        if (serviceSymbol.isOperator() && (symbolCurrent.getPriority() <= serviceSymbol.getPriority())) {
                            resultExpression.push(serviceSymbol);
                            serviceSymbolStack.pop();
                        } else {
                            break;
                        }
                    }
                    serviceSymbolStack.push(symbolCurrent);
                } else if (symbolCurrent instanceof OpeningBracket) {
                    serviceSymbolStack.push(symbolCurrent);
                } else if (symbolCurrent instanceof ClosingBracket) {
                    try {
                        serviceSymbol = serviceSymbolStack.peek();
                        while (!(serviceSymbol instanceof OpeningBracket)) {
                            resultExpression.push(serviceSymbol);
                            serviceSymbolStack.pop();
                            serviceSymbol = serviceSymbolStack.peek();
                        }
                        serviceSymbolStack.pop();
                    } catch (Exception e){
                        throw new InputExpressionException("Ошибка разбора скобок. Проверьте правильность выражения."+userExpression);
                    }
                }
            }catch (Exception e){
                resultExpressionString.append(currentSymbol);
            }
        }

        if (resultExpressionString.length() != 0) {
            resultExpression.push(new Number(resultExpressionString.toString()));
        }
        // Если в стеке остались операторы, добавляем их в входную строку
        while (serviceSymbolStack.size() > 0) {
            resultExpression.push(serviceSymbolStack.peek());
            serviceSymbolStack.pop();
        }

        Deque<Mom> result = new ArrayDeque<>();

        while (resultExpression.size() != 0) {
            result.addFirst(resultExpression.pop());
        }
        return  result;

//        return resultExpression;


//        StringBuilder result = new StringBuilder();
//        while (resultExpression.size() != 0) {
//            Mom mom = resultExpression.pollLast();
//            if (!(mom instanceof Number)){
//                result.append(" ").append(mom.getValue()).append(" ");
//            } else result.append(" ").append(((Number) mom).getDoubleValue()).append(" ");
//        }
//        return result.toString();
    }
}
