package CalcMVC;

import CalcMVC.View.CalcView;

/**
 * Created by yevgen on 14.12.16.
 */
public class Calculator {

    /**
     * @param args
     */
    public static void main(String[] args) {
            System.out.println("START MAIN");
            System.out.println("Call CalcView from MAIN");
        CalcView calcView = new CalcView("Калькулятор");
            System.out.println("Call CalcView from MAIN. setVisible(true)");
        calcView.setVisible(true);
            System.out.println("FINISH MAIN");

    }
}
