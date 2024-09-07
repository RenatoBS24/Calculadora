package com.calculadora.interfaz;

import com.calculadora.Clases.Postfija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JButton a7Button;
    private JButton a4Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a9Button;
    private JButton a6Button;
    private JButton xButton;
    private JButton button8;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton button12;
    private JButton ACButton;
    private JButton xButton1;
    private JButton button3;
    private JButton button4;
    private JButton a0Button;
    private JButton button1;
    private JButton button2;
    private JButton button5;
    private JTextArea formula;
    private JPanel panel;

    public Calculator() {
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setVisible(true);
        pack();
        setSize(600,520);
        setLocationRelativeTo(null);
        setResizable(false);
        formula.setEditable(false);
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+1);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+2);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+3);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+4);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+5);
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+6);
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+7);
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+8);
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+9);
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+0);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+"(");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+")");
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+"+");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+"-");
            }
        });
        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+"*");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+"/");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText(formula.getText()+"^");
            }
        });
        ACButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formula.setText("");
            }
        });
        xButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = "";
               for(int i = 0;i<formula.getText().length()-1;i++){
                   text+=String.valueOf(formula.getText().charAt(i));
               }
               formula.setText(text);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double result = Postfija.Result(Postfija.notation(formula.getText()));
                if(result==(int)result){
                    formula.setText(String.valueOf((int)result));
                }else{
                    formula.setText(String.valueOf(result));
                }
            }
        });
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
