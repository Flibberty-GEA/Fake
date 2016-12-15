package CalcMVC.Controller;

import CalcMVC.Model.CalcModel;

import javax.swing.JTextField;

/**
 * Created by yevgen on 14.12.16.
 */
public class CalcController {


    private JTextField  ditString = null;

    private static CalcController instance = null;

    private CalcModel calcModel;

    public static CalcController getInstance() {
        System.out.println("Hello from CalcController.getInstance");
        if (instance==null) {
            instance = new CalcController();
        }
        System.out.println("Return instance of CalcController with calcModel");
        return instance;
    }

    public void setTextComponent(JTextField textComponent) {
        System.out.println("Hello from CalcController. SetTextComponent get textComponent-> "+textComponent);
        this.ditString = textComponent;
        System.out.println("VOID this.ditString "+this.ditString);
    }

    public CalcController()
    {
        System.out.println("CREATE CalcController");
        System.out.println("CalcController call to calcModel. CREATE calcModel");
        calcModel = new CalcModel();
    }

    public void SetNumberText(String num)
    {
        System.out.println("Hello from CalcController. SetNumberText get num-> "+num);
        String lastDit = this.ditString.getText();
        System.out.println("lastDit-> "+lastDit);
        if ((lastDit.equals("")) && (num.equals("."))){num = "";}
        this.ditString.setText(lastDit+num);
        System.out.println("VOID this.ditString "+this.ditString);
    }

    public void ClearNumberText()
    {
        this.ditString.setText("");
    }

    public void SetNegativeSign()
    {
        System.out.println("Hello from CalcController. SetNegativeSign");
        String lastDit = this.ditString.getText();
        System.out.println("lastDit-> "+lastDit);
        this.ditString.setText("-"+lastDit);
        System.out.println("VOID this.ditString "+this.ditString);
    }

    public void SetOperation(int operationCode)
    {
        System.out.println("Hello from CalcController. SetOperation get operationCode-> "+operationCode);
        System.out.println("Call to calcModel");
        calcModel.setOperationCode(operationCode);
        if (calcModel.getErrorCode() == -1){
            System.out.println("Call to calcModel");
            calcModel.setFirstNum(Double.parseDouble(this.ditString.getText()));}
        this.ditString.setText("");
        System.out.println("VOID this.ditString "+this.ditString);
    }

    public void GetResult()
    {
        System.out.println("Hello from CalcController. GetResult");
        String resultString = "";
        double result = 0;
        System.out.println("Call to calcModel");
        calcModel.setSecondNumber(Double.parseDouble(this.ditString.getText()));
        result = calcModel.GetResult();
        System.out.println("result from -> calcModel.GetResult-> "+result);
        if (calcModel.getErrorCode() == 0) {
            resultString = "Попытка деления на ноль!";
            System.out.println("resultString-> "+resultString);
        }
        else {
            resultString = String.valueOf(result);
            System.out.println("resultString-> "+resultString);
        }
        this.ditString.setText(resultString);
        System.out.println("VOID this.ditString "+this.ditString);
    }
}
