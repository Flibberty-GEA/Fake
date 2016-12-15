package CalcMVC.View;

import CalcMVC.Controller.CalcController;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by yevgen on 14.12.16.
 */
public class CalcView extends JFrame {


    private static final long serialVersionUID = 1L;

    private CalcController calcController = null;

    private JTextField  ditString;
    private JButton  btn1;
    private JButton  btn2;
    private JButton  btn3;
    private JButton  btn4;
    private JButton  btn5;
    private JButton  btn6;
    private JButton  btn7;
    private JButton  btn8;
    private JButton  btn9;
    private JButton  btn0;

    private JButton  btnC;
    private JButton  btnPlus;
    private JButton  btnMinus;
    private JButton  btnMul;
    private JButton  btnDiv;
    private JButton  btnNegative;
    private JButton  btnPoint;
    private JButton  btnEquals;

    public CalcView(String title)
    {
        super(title);

        System.out.println("CREATE CalcView");
        calcController = CalcController.getInstance();
        System.out.println("calcController-> "+calcController);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 195);
        this.setLayout(new FlowLayout());

        ditString = new JTextField(20);
        System.out.print("Call calcController from CalcView: ");
        calcController.setTextComponent(ditString);

        ditString.setHorizontalAlignment(JTextField.RIGHT);
        btn1 = new JButton("1");  btn1.setActionCommand("1");
        btn2 = new JButton("2");  btn2.setActionCommand("2");
        btn3 = new JButton("3");  btn3.setActionCommand("3");
        btnC = new JButton("C");
        btnC.setPreferredSize(new Dimension(84, 26));
        btn4 = new JButton("4");  btn4.setActionCommand("4");
        btn5 = new JButton("5");  btn5.setActionCommand("5");
        btn6 = new JButton("6");  btn6.setActionCommand("6");
        btnPlus = new JButton("+");  btnPlus.setActionCommand("0");
        btnMinus = new JButton("-"); btnMinus.setActionCommand("1");
        btn7 = new JButton("7");  btn7.setActionCommand("7");
        btn8 = new JButton("8");  btn8.setActionCommand("8");
        btn9 = new JButton("9");  btn9.setActionCommand("9");
        btnMul = new JButton("*");  btnMul.setActionCommand("2");
        btnDiv = new JButton("/");  btnDiv.setActionCommand("3");
        btn0 = new JButton("0");  btn0.setActionCommand("0");
        btnPoint = new JButton(","); btnPoint.setActionCommand(".");
        btnNegative = new JButton("/-/");
        btnEquals = new JButton("=");
        btnEquals.setPreferredSize(new Dimension(84, 26));

        ActionListener numActionListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("Create numActionListener for CalcView");
                System.out.print("Call calcController from CalcView: ");
                calcController.SetNumberText(e.getActionCommand());
            }
        };
        System.out.println("Create btns (0-9) for CalcView.btnC");
        btn1.addActionListener(numActionListener);

        btn2.addActionListener(numActionListener);

        btn3.addActionListener(numActionListener);

        btn4.addActionListener(numActionListener);

        btn5.addActionListener(numActionListener);

        btn6.addActionListener(numActionListener);

        btn7.addActionListener(numActionListener);

        btn8.addActionListener(numActionListener);

        btn9.addActionListener(numActionListener);

        btn0.addActionListener(numActionListener);

        btnC.addActionListener(new ActionListener() {

                                   public void actionPerformed(ActionEvent e) {
                                       System.out.println("addActionListener for CalcView.btnC");
                                       System.out.print("Call calcController from CalcView: ");
                                       calcController.ClearNumberText();
                                   }
                               }
        );

        btnNegative.addActionListener(new ActionListener() {

                                          public void actionPerformed(ActionEvent e) {
                                              System.out.println("addActionListener for CalcView.btnNegative");
                                              System.out.print("Call calcController from CalcView: ");
                                              calcController.SetNegativeSign();
                                          }
                                      }
        );

        btnPlus.addActionListener(new ActionListener() {

                                      public void actionPerformed(ActionEvent e) {
                                          System.out.println("addActionListener for CalcView.btnPlus");
                                          System.out.print("Call calcController from CalcView: ");
                                          calcController.SetOperation(0);
                                      }
                                  }
        );

        btnMinus.addActionListener(new ActionListener() {

                                       public void actionPerformed(ActionEvent e) {
                                           System.out.println("addActionListener for CalcView.btnMinus");
                                           System.out.print("Call calcController from CalcView: ");
                                           calcController.SetOperation(1);
                                       }
                                   }
        );

        btnMul.addActionListener(new ActionListener() {

                                     public void actionPerformed(ActionEvent e) {
                                         System.out.println("addActionListener for CalcView.btnMul");
                                         System.out.print("Call calcController from CalcView: ");
                                         calcController.SetOperation(2);
                                     }
                                 }
        );

        btnDiv.addActionListener(new ActionListener() {

                                     public void actionPerformed(ActionEvent e) {
                                         System.out.println("addActionListener for CalcView.btnDiv");
                                         System.out.print("Call calcController from CalcView: ");
                                         calcController.SetOperation(3);
                                     }
                                 }
        );

        btnPoint.addActionListener(new ActionListener() {

                                       public void actionPerformed(ActionEvent e) {
                                           System.out.println("addActionListener for CalcView.btnPoint");
                                           System.out.print("Call calcController from CalcView: ");
                                           calcController.SetNumberText(".");
                                       }
                                   }
        );

        btnEquals.addActionListener(new ActionListener() {

                                        public void actionPerformed(ActionEvent e) {
                                            System.out.println("addActionListener for CalcView.btnEquals");
                                            System.out.print("Call calcController from CalcView: ");
                                            calcController.GetResult();
                                        }
                                    }
        );
        System.out.println("add btns for CalcView");
        this.add(ditString);
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btnC);
        this.add(btn4);
        this.add(btn5);
        this.add(btn6);
        this.add(btnPlus);
        this.add(btnMinus);
        this.add(btn7);
        this.add(btn8);
        this.add(btn9);
        this.add(btnMul);
        this.add(btnDiv);
        this.add(btn0);
        this.add(btnNegative);
        this.add(btnPoint);
        this.add(btnEquals);
        System.out.println("finish CREATE CalcView");
    }
}
