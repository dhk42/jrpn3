package org.dhk42.jrpn3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class JrpnGui2 implements ActionListener {

    private JFrame window1;
    private JButton zeroButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton sqrtButton;
    private JButton exButton;
    private JButton power10Button;
    private JButton yxButton;
    private JButton invertButton;
    private JButton clrallButton;
    private JButton sqrButton;
    private JButton timesButton;
    private JButton enterButton;
    private JButton offButton;
    private JButton backButton;
    private JButton lnButton;
    private JButton logButton;
    private JButton percentButton;
    private JButton deltapercentButton;
    private JButton sinButton;
    private JButton divideButton;
    private JButton cosButton;
    private JButton eexButton;
    private JButton tanButton;
    private JButton minusButton;
    private JButton pointButton;
    private JButton plusButton;
    private JButton clxButton;
    private JButton chsButton;
    private JLabel msgLabel;
    private JTextField calcField;
    private GridBagLayout gbl;

    private static GridBagConstraints gbc;

    private static final int WINDOW1X = 170;//150;
    private static final int WINDOW1Y = 170;//150;

    private RPN calc;

    private boolean edit;

    private static Color noEditColor = new Color(160, 160, 160);

    private static Color EditColor = new Color(200, 200, 200);

    public void jrpn1() {
    }

    public void initGUI() throws UnsupportedLookAndFeelException {
        byte b1 = 67;//65
        byte b2 = 27;
        this.calc = new RPN();
        this.window1 = new JFrame("jrpn");
        this.window1.setResizable(false);
        this.window1.setBackground(Color.darkGray);
        UIManager.setLookAndFeel(new MetalLookAndFeel());
        this.window1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.exit(0);
            }
        });
        this.gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        this.window1.getContentPane().setLayout(this.gbl);
        gbc.fill = 2;
        this.msgLabel = new JLabel(new String("jrpn scientific calculator"), 0);
        this.oneButton = new JButton("1");
        this.oneButton.addActionListener(this);
        this.oneButton.setActionCommand("one");
        this.oneButton.setPreferredSize(new Dimension(b1, b2));
        this.twoButton = new JButton("2");
        this.twoButton.addActionListener(this);
        this.twoButton.setActionCommand("two");
        this.twoButton.setPreferredSize(new Dimension(b1, b2));
        this.threeButton = new JButton("3");
        this.threeButton.addActionListener(this);
        this.threeButton.setActionCommand("three");
        this.threeButton.setPreferredSize(new Dimension(b1, b2));
        this.fourButton = new JButton("4");
        this.fourButton.addActionListener(this);
        this.fourButton.setActionCommand("four");
        this.fourButton.setPreferredSize(new Dimension(b1, b2));
        this.fiveButton = new JButton("5");
        this.fiveButton.addActionListener(this);
        this.fiveButton.setActionCommand("five");
        this.fiveButton.setPreferredSize(new Dimension(b1, b2));
        this.sixButton = new JButton("6");
        this.sixButton.addActionListener(this);
        this.sixButton.setActionCommand("six");
        this.sixButton.setPreferredSize(new Dimension(b1, b2));
        this.sevenButton = new JButton("7");
        this.sevenButton.addActionListener(this);
        this.sevenButton.setActionCommand("seven");
        this.sevenButton.setPreferredSize(new Dimension(b1, b2));
        this.eightButton = new JButton("8");
        this.eightButton.addActionListener(this);
        this.eightButton.setActionCommand("eight");
        this.eightButton.setPreferredSize(new Dimension(b1, b2));
        this.nineButton = new JButton("9");
        this.nineButton.addActionListener(this);
        this.nineButton.setActionCommand("nine");
        this.nineButton.setPreferredSize(new Dimension(b1, b2));
        this.zeroButton = new JButton("0");
        this.zeroButton.addActionListener(this);
        this.zeroButton.setActionCommand("zero");
        this.zeroButton.setPreferredSize(new Dimension(b1, b2));
        this.clxButton = new JButton("cl x");
        this.clxButton.addActionListener(this);
        this.clxButton.setActionCommand("del");
        this.clxButton.setPreferredSize(new Dimension(b1, b2));
        this.sqrtButton = new JButton("sqrt");
        this.sqrtButton.addActionListener(this);
        this.sqrtButton.setActionCommand("sqrt");
        this.sqrtButton.setPreferredSize(new Dimension(b1, b2));
        this.exButton = new JButton("e^x");
        this.exButton.addActionListener(this);
        this.exButton.setActionCommand("ex");
        this.exButton.setPreferredSize(new Dimension(b1, b2));
        this.power10Button = new JButton("10^x");
        this.power10Button.addActionListener(this);
        this.power10Button.setActionCommand("power");
        this.power10Button.setPreferredSize(new Dimension(b1, b2));
        this.yxButton = new JButton("y^x");
        this.yxButton.addActionListener(this);
        this.yxButton.setActionCommand("yx");
        this.yxButton.setPreferredSize(new Dimension(b1, b2));
        this.invertButton = new JButton("1/x");
        this.invertButton.addActionListener(this);
        this.invertButton.setActionCommand("invert");
        this.invertButton.setPreferredSize(new Dimension(b1, b2));
        this.clrallButton = new JButton("cl all");
        this.clrallButton.addActionListener(this);
        this.clrallButton.setActionCommand("clr");
        this.clrallButton.setPreferredSize(new Dimension(b1, b2));
        this.sqrButton = new JButton("x^2");
        this.sqrButton.addActionListener(this);
        this.sqrButton.setActionCommand("sqr");
        this.sqrButton.setPreferredSize(new Dimension(b1, b2));
        this.timesButton = new JButton("*");
        this.timesButton.addActionListener(this);
        this.timesButton.setActionCommand("times");
        this.timesButton.setPreferredSize(new Dimension(b1, b2));
        this.enterButton = new JButton("enter");
        this.enterButton.addActionListener(this);
        this.enterButton.setActionCommand("enter");
        this.enterButton.setPreferredSize(new Dimension(b1, b2));
        this.offButton = new JButton("off");
        this.offButton.addActionListener(this);
        this.offButton.setActionCommand("off");
        this.offButton.setPreferredSize(new Dimension(b1, b2));
        this.backButton = new JButton("back");
        this.backButton.addActionListener(this);
        this.backButton.setActionCommand("back");
        this.backButton.setPreferredSize(new Dimension(b1, b2));
        this.lnButton = new JButton("ln");
        this.lnButton.addActionListener(this);
        this.lnButton.setActionCommand("ln");
        this.lnButton.setPreferredSize(new Dimension(b1, b2));
        this.logButton = new JButton("log");
        this.logButton.addActionListener(this);
        this.logButton.setActionCommand("log");
        this.logButton.setPreferredSize(new Dimension(b1, b2));
        this.percentButton = new JButton("%");
        this.percentButton.addActionListener(this);
        this.percentButton.setActionCommand("percent");
        this.percentButton.setPreferredSize(new Dimension(b1, b2));
        this.deltapercentButton = new JButton("d%");
        this.deltapercentButton.addActionListener(this);
        this.deltapercentButton.setActionCommand("deltapercent");
        this.deltapercentButton.setPreferredSize(new Dimension(b1, b2));
        this.sinButton = new JButton("sin");
        this.sinButton.addActionListener(this);
        this.sinButton.setActionCommand("sin");
        this.sinButton.setPreferredSize(new Dimension(b1, b2));
        this.divideButton = new JButton("/");
        this.divideButton.addActionListener(this);
        this.divideButton.setActionCommand("divide");
        this.divideButton.setPreferredSize(new Dimension(b1, b2));
        this.cosButton = new JButton("cos");
        this.cosButton.addActionListener(this);
        this.cosButton.setActionCommand("cos");
        this.cosButton.setPreferredSize(new Dimension(b1, b2));
        this.eexButton = new JButton("EEX");
        this.eexButton.addActionListener(this);
        this.eexButton.setActionCommand("eex");
        this.eexButton.setPreferredSize(new Dimension(b1, b2));
        this.tanButton = new JButton("tan");
        this.tanButton.addActionListener(this);
        this.tanButton.setActionCommand("tan");
        this.tanButton.setPreferredSize(new Dimension(b1, b2));
        this.minusButton = new JButton("-");
        this.minusButton.addActionListener(this);
        this.minusButton.setActionCommand("minus");
        this.minusButton.setPreferredSize(new Dimension(b1, b2));
        this.pointButton = new JButton(".");
        this.pointButton.addActionListener(this);
        this.pointButton.setActionCommand("point");
        this.pointButton.setPreferredSize(new Dimension(b1, b2));
        this.plusButton = new JButton("+");
        this.plusButton.addActionListener(this);
        this.plusButton.setActionCommand("plus");
        this.plusButton.setPreferredSize(new Dimension(b1, b2));
        this.chsButton = new JButton("CHS");
        this.chsButton.addActionListener(this);
        this.chsButton.setActionCommand("chs");
        this.chsButton.setPreferredSize(new Dimension(b1, b2));
        this.calcField = new JTextField(18);
        this.calcField.setText("0.0");
        this.calcField.setFont(new Font("monospaced", 0, 25));
        this.calcField.setBackground(noEditColor);
        this.calcField.setEditable(false);
//    this;
        this.calcField.setHorizontalAlignment(4);
        gbc.fill = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        this.gbl.setConstraints(this.msgLabel, gbc);
        this.msgLabel.setHorizontalAlignment(0);
        this.window1.getContentPane().add(this.msgLabel);
        gbc.gridy++;
        this.gbl.setConstraints(this.calcField, gbc);
        this.window1.getContentPane().add(this.calcField);
        gbc.gridwidth = 1;
        gbc.gridy++;
        this.gbl.setConstraints(this.clxButton, gbc);
        this.window1.getContentPane().add(this.clxButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.sqrtButton, gbc);
        this.window1.getContentPane().add(this.sqrtButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.exButton, gbc);
        this.window1.getContentPane().add(this.exButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.power10Button, gbc);
        this.window1.getContentPane().add(this.power10Button);
        gbc.gridx++;
        this.gbl.setConstraints(this.yxButton, gbc);
        this.window1.getContentPane().add(this.yxButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.invertButton, gbc);
        this.window1.getContentPane().add(this.invertButton);
        gbc.gridx = 0;
        gbc.gridy++;
        this.gbl.setConstraints(this.clrallButton, gbc);
        this.window1.getContentPane().add(this.clrallButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.sqrButton, gbc);
        this.window1.getContentPane().add(this.sqrButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.lnButton, gbc);
        this.window1.getContentPane().add(this.lnButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.logButton, gbc);
        this.window1.getContentPane().add(this.logButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.percentButton, gbc);
        this.window1.getContentPane().add(this.percentButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.deltapercentButton, gbc);
        this.window1.getContentPane().add(this.deltapercentButton);
        gbc.gridx++;
        gbc.gridx = 0;
        gbc.gridy++;
        this.gbl.setConstraints(this.sinButton, gbc);
        this.window1.getContentPane().add(this.sinButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.chsButton, gbc);
        this.window1.getContentPane().add(this.chsButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.sevenButton, gbc);
        this.window1.getContentPane().add(this.sevenButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.eightButton, gbc);
        this.window1.getContentPane().add(this.eightButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.nineButton, gbc);
        this.window1.getContentPane().add(this.nineButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.divideButton, gbc);
        this.window1.getContentPane().add(this.divideButton);
        gbc.gridx = 0;
        gbc.gridy++;
        this.gbl.setConstraints(this.cosButton, gbc);
        this.window1.getContentPane().add(this.cosButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.eexButton, gbc);
        this.window1.getContentPane().add(this.eexButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.fourButton, gbc);
        this.window1.getContentPane().add(this.fourButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.fiveButton, gbc);
        this.window1.getContentPane().add(this.fiveButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.sixButton, gbc);
        this.window1.getContentPane().add(this.sixButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.timesButton, gbc);
        this.window1.getContentPane().add(this.timesButton);
        gbc.gridx = 0;
        gbc.gridy++;
        this.gbl.setConstraints(this.tanButton, gbc);
        this.window1.getContentPane().add(this.tanButton);
        gbc.gridx++;
        gbc.anchor = 11;
        gbc.fill = 1;
        gbc.weighty = 1.0D;
        gbc.gridheight = 0;
        this.gbl.setConstraints(this.enterButton, gbc);
        this.window1.getContentPane().add(this.enterButton);
        gbc.weighty = 0.0D;
        gbc.fill = 2;
        gbc.gridx++;
        this.gbl.setConstraints(this.oneButton, gbc);
        this.window1.getContentPane().add(this.oneButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.twoButton, gbc);
        this.window1.getContentPane().add(this.twoButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.threeButton, gbc);
        this.window1.getContentPane().add(this.threeButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.minusButton, gbc);
        this.window1.getContentPane().add(this.minusButton);
        gbc.gridx = 0;
        gbc.gridy++;
        this.gbl.setConstraints(this.offButton, gbc);
        this.window1.getContentPane().add(this.offButton);
        gbc.gridx++;
        gbc.gridx++;
        this.gbl.setConstraints(this.zeroButton, gbc);
        this.window1.getContentPane().add(this.zeroButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.pointButton, gbc);
        this.window1.getContentPane().add(this.pointButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.backButton, gbc);
        this.window1.getContentPane().add(this.backButton);
        gbc.gridx++;
        this.gbl.setConstraints(this.plusButton, gbc);
        this.window1.getContentPane().add(this.plusButton);
    }

    public void showWindow() {
        this.window1.setLocation(150, 150);
        this.window1.pack();
        this.window1.setSize((this.window1.getSize()).width, (this.window1.getSize()).height);
        this.window1.validate();
        this.window1.show();
    }

    @Override
    public void actionPerformed(ActionEvent paramActionEvent) {
        try {
            String actionCommand = paramActionEvent.getActionCommand();
            String calcFieldText = this.calcField.getText();
            switch (actionCommand) {
                case "enter":
                    if (calcFieldText.endsWith("e")) {
                        this.calcField.setText(calcFieldText + "0");
                    }   if (calcFieldText.endsWith("-")) {
                        this.calcField.setText(calcFieldText + "0");
                    }   this.edit = false;
                    this.calc.doit(new Double(this.calcField.getText()));
                    break;
                case "off":
                    this.window1.dispose();
                    System.exit(0);
                case "back":
                    if (this.edit) {
                        this.calcField.selectAll();
                        if (this.calcField.getSelectionEnd() > 0) {
                            this.calcField.setSelectionEnd(this.calcField.getSelectionEnd() - 1);
                            this.calcField.setText(this.calcField.getSelectedText());
                        } else {
                            this.calcField.setText(this.calc.getX().toString());
                            this.edit = false;
                        }
                    } else {
                        this.calc.doit("del");
                        this.calcField.setText(this.calc.getX().toString());
                    }   break;
                case "point":
                    if (!this.edit) {
                        this.calcField.setText("0.");
                        this.edit = true;
                    } else {
                        this.calcField.setText(calcFieldText + ".");
                    }   break;
                case "one":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("1");
                    } else {
                        this.calcField.setText(calcFieldText + "1");
                    }   break;
                case "two":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("2");
                    } else {
                        this.calcField.setText(calcFieldText + "2");
                    }   break;
                case "three":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("3");
                    } else {
                        this.calcField.setText(calcFieldText + "3");
                    }   break;
                case "four":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("4");
                    } else {
                        this.calcField.setText(calcFieldText + "4");
                    }   break;
                case "five":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("5");
                    } else {
                        this.calcField.setText(calcFieldText + "5");
                    }   break;
                case "six":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("6");
                    } else {
                        this.calcField.setText(calcFieldText + "6");
                    }   break;
                case "seven":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("7");
                    } else {
                        this.calcField.setText(calcFieldText + "7");
                    }   break;
                case "eight":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("8");
                    } else {
                        this.calcField.setText(calcFieldText + "8");
                    }   break;
                case "nine":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("9");
                    } else {
                        this.calcField.setText(calcFieldText + "9");
                    }   break;
                case "zero":
                    if (!this.edit) {
                        this.edit = true;
                        this.calcField.setText("0");
                    } else {
                        this.calcField.setText(calcFieldText + "0");
                    }   break;
                case "chs":
                    if (!this.edit) {
                        this.calc.doit(actionCommand);
                        this.calcField.setText(this.calc.getX().toString());
                    } else {
                        System.out.println("actionCommand=" + actionCommand);
                        char c = Character.MAX_VALUE;//I with bar
                        for (byte b = 0; b <= calcFieldText.length() - 1; b++) {
                            if (calcFieldText.regionMatches(true, b, "e", 0, 1)) {
                                c = (char) b;
                            }
                        }
                        if (c < 'x') { //u with accent
                            if (calcFieldText.regionMatches(c + 1, "-", 0, 1)) {
                                this.calcField.selectAll();
                                this.calcField.setSelectionEnd(c + 1);
                                String str3 = new String(this.calcField.getSelectedText());
                                this.calcField.selectAll();
                                this.calcField.setSelectionStart(c + 2);
                                String str4 = new String(this.calcField.getSelectedText());
                                this.calcField.setText(str3 + str4);
                            } else {
                                this.calcField.selectAll();
                                this.calcField.setSelectionEnd(c + 1);
                                String str3 = new String(this.calcField.getSelectedText());
                                this.calcField.selectAll();
                                this.calcField.setSelectionStart(c + 1);
                                String str4 = new String(this.calcField.getSelectedText());
                                this.calcField.setText(str3 + "-" + str4);
                            }
                        } else if (!calcFieldText.startsWith("-")) {
                            this.calcField.setText("-" + calcFieldText);
                        } else {
                            this.calcField.selectAll();
                            this.calcField.setSelectionStart(1);
                            this.calcField.setText(this.calcField.getSelectedText());
                        }
                    }   break;
                case "eex":
                    if (!this.edit) {
                        this.calcField.setText("1.0e");
                        this.edit = true;
                    } else {
                        this.calcField.setText(calcFieldText + "e");
                    }   break;
                case "clx":
                    if (!this.edit) {
                        this.calc.doit(actionCommand);
                    } else {
                        this.calcField.setText(this.calc.getX().toString());
                    }   break;
                default:
                    if (calcFieldText.endsWith("e")) {
                        this.calcField.setText(calcFieldText + "0");
                    }   if (calcFieldText.endsWith("-")) {
                        this.calcField.setText(calcFieldText + "0");
                    }   if (this.edit) {
                        this.edit = false;
                        this.calc.doit(new Double(this.calcField.getText()));
                    }   this.calc.doit(actionCommand);
                    this.calcField.setText(this.calc.getX().toString());
                    break;
            }
            if (this.edit) {
                this.calcField.setBackground(EditColor);
            } else {
                this.calcField.setBackground(noEditColor);
            }
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(window1, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JrpnGui2 g = new JrpnGui2();
                try {
                    g.initGUI();
                    g.showWindow();
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
