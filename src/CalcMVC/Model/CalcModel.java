package CalcMVC.Model;

/**
 * Created by yevgen on 14.12.16.
 */
public class CalcModel {


    private double firstNum = 0;

    private double secondNumber = 0;

    private int operationCode = 0;

    private int errorCode = -1;

    public void setFirstNum(double firstNum) {
        System.out.println("set FirstNum in CalcModel "+firstNum);
        this.firstNum = firstNum;
    }

    public void setSecondNumber(double secondNumber) {
        System.out.println("set SecondNum in CalcModel "+secondNumber);
        this.secondNumber = secondNumber;
    }

    public void setOperationCode(int operationCode) {
        System.out.println("set OperationCode in CalcModel "+operationCode);
        this.operationCode = operationCode;
    }

    public int getErrorCode() {
        System.out.println("get getErrorCode from CalcModel "+errorCode);
        return errorCode;
    }

    private double Summ()
    {
        errorCode = -1;
        System.out.println("Summ from CalcModel "+(firstNum + secondNumber));
        return firstNum + secondNumber;
    }

    private double Sub()
    {
        errorCode = -1;
        System.out.println("Sub from CalcModel "+(firstNum - secondNumber));
        return firstNum - secondNumber;
    }

    private double Mul()
    {
        errorCode = -1;
        System.out.println("Mul from CalcModel "+(firstNum * secondNumber));
        return firstNum * secondNumber;
    }

    private double Div()
    {
        if (this.secondNumber != 0)
        {
            System.out.println("Div from CalcModel "+(firstNum / secondNumber));
            return firstNum / secondNumber;
        }
        else
        {
            errorCode = 0;
            System.out.println("Div from CalcModel "+0);
            return 0;
        }
    }

    public double GetResult()
    {
        System.out.print("GetResult from CalcModel. operationCode-> "+operationCode);
        double result = 0;
        switch (this.operationCode) {
            case 0:
                result = Summ();
                break;
            case 1:
                result = Sub();
                break;
            case 2:
                result = Mul();
                break;
            case 3:
                result = Div();
                break;
            default:
                result = 0;
                break;
        }
        System.out.println(" Result-> "+result);
        return result;
    }
}
