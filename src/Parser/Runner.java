package Parser;

/**
 * Created by yevgen on 15.12.16.
 */
public class Runner {
    public static void main(String[] args) {
        ParserRPN parserRPN = new ParserRPN();
//        String input = "2+0";
        String input = "(-31)+27*(3/(14-56))^(-2)";
        try{
            String output = parserRPN.toRPN(input);
            System.out.println(output);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    GET -> 2+0
//    RETURN -> 2 0 +

//    GET -> (-31)+27*(3/(14-56))^(-2)
//        -> (0-31)+27*(3/(14-56))^(0-2)
//    RETURN -> 0  31 - 27  3  14  56 - /  0  2 - ^ * +

//    GET -> (-31)+27*(3+(14-56))*(-2)
//    CHG -> (0-31)+27*(3+(14-56))*(0-2)
//    RETURN -> 0  31 - 27  3  14  56 - + *   0  2 - * +
}
