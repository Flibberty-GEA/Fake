package FakeCalc;

/**
 * @author Yevgen Goliuk
 */
public class MainRunnerClass {
//public static final Logger log = Lo   gManager.getLogger(MainRunnerClass.class);

    public static void main(String[] args) {
//        String inputString = "2";
//        String inputString = "( 2 )";
//        String inputString = "( 2 + -3 )";
        String inputString = "( 2 + ( 4 * 3 ) + 4 ) + 3";
//        String inputString = "2 + 4 * 3 + root 2 3";
        Double result = new MyExecutor(inputString).execute();
        System.out.println("RESULT = "+result);
    }
}
