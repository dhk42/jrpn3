/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dhk42.jrpn3;

import java.math.BigDecimal;
import java.util.Stack;

/**
 *
 * @author davidklatte
 */
public class RPN {

    private int BaseMode;
    private int FormatMode;
    private int AngleMode;
    private int TimeMode;
    private Stack st;

    public static final String CHS = "chs";
    public static final String DELTAPERCENT = "deltapercent";
    public static final String CLR = "clr";
    public static final String PERCENT = "percent";
    public static final String RANDOMIZE = "randomize";
    public static final String RAND = "rand";
    public static final String XRTY = "xrty";
    public static final String SWAP = "swap";
    public static final String EX = "ex";
    public static final String LN = "ln";
    public static final String LOG = "log";
    public static final String POWER = "power";
    public static final String SQRT = "sqrt";
    public static final String INVERT = "invert";
    public static final String SQR = "sqr";
    public static final String YX = "yx";
    public static final String DEL = "del";
    public static final String TAN = "tan";
    public static final String COS = "cos";
    public static final String SIN = "sin";
    public static final String DIVIDE = "divide";
    public static final String TIMES = "times";
    public static final String MINUS = "minus";
    public static final String PLUS = "plus";

    public static final int DEC = 1;
    public static final int HEX = 2;
    public static final int BIN = 3;
    public static final int OCT = 4;
    public static final int DEG = 1;
    public static final int RAD = 2;
    public static final int GRA = 3;
    public static final int STD = 1;
    public static final int FIX = 2;
    public static final int SCI = 3;
    public static final int ENG = 4;
    public static int tim = 1;
    public static int ntm = 2;

    public RPN(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        init(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public RPN() {
        init(1, 1, 1, tim);
    }

    public int getFormatMode() {
        return this.FormatMode;
    }

    public void setFormatMode(int paramInt) {
        if (paramInt <= 4 && paramInt >= 1) {
            this.FormatMode = paramInt;
        } else {
            this.FormatMode = 1;
        }
    }

    public int getAngleMode() {
        return this.AngleMode;
    }

    public void setAngleMode(int paramInt) {
        if (paramInt <= 3 && paramInt <= 1) {
            this.AngleMode = paramInt;
        } else {
            this.AngleMode = 1;
        }
    }

    public int getTimeMode() {
        return this.TimeMode;
    }

    public void setTimeMode(int paramInt) {
        if (paramInt == 1 || paramInt == 2) {
            this.TimeMode = paramInt;
        } else {
            this.TimeMode = 1;
        }
    }

    public int getBaseMode() {
        return this.BaseMode;
    }

    public void setBaseMode(int paramInt) {
        if (paramInt <= 4 && paramInt >= 1) {
            this.BaseMode = paramInt;
        } else {
            this.BaseMode = 1;
        }
    }

    public Double getX() {
        return new Double(Peek());
    }

    protected void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        setBaseMode(paramInt1);
        setAngleMode(paramInt2);
        setFormatMode(paramInt3);
        setTimeMode(paramInt4);
        this.st = new Stack();
    }

    public void doit(Double paramDouble) {
        Push(paramDouble.doubleValue());
    }

    public void doit(double paramDouble) {
        Push(paramDouble);
    }

    public void doit(String paramString) {
        paramString = paramString.trim();
        paramString = paramString.toLowerCase();
        if (paramString.equals(PLUS)) {
            plus();
        } else if (paramString.equals(MINUS)) {
            minus();
        } else if (paramString.equals(TIMES)) {
            times();
        } else if (paramString.equals(DIVIDE)) {
            divide();
        } else if (paramString.equals(SIN)) {
            sin();
        } else if (paramString.equals(COS)) {
            cos();
        } else if (paramString.equals(TAN)) {
            tan();
        } else if (paramString.equals(DEL)) {
            del();
        } else if (paramString.equals(YX)) {
            yx();
        } else if (paramString.equals(SQR)) {
            sqr();
        } else if (paramString.equals(INVERT)) {
            invert();
        } else if (paramString.equals(SQRT)) {
            sqrt();
        } else if (paramString.equals(POWER)) {
            power();
        } else if (paramString.equals(LOG)) {
            log();
        } else if (paramString.equals(LN)) {
            ln();
        } else if (paramString.equals(EX)) {
            ex();
        } else if (paramString.equals(SWAP)) {
            swap();
        } else if (paramString.equals(XRTY)) {
            xrty();
        } else if (paramString.equals(RAND)) {
            rand();
        } else if (paramString.equals(RANDOMIZE)) {
            randomize();
        } else if (paramString.equals(PERCENT)) {
            percent();
        } else if (paramString.equals(CLR)) {
            clr();
        } else if (paramString.equals(DELTAPERCENT)) {
            deltapercent();
        } else if (paramString.equals(CHS)) {
            chs();
        } else {
            error("Invalid Argument");
        }
    }

    private void deltapercent() {
        double d1 = Pop();
        double d2 = Pop();
        Push((d1 - d2) / d2 * 100.0D);
    }

    private void chs() {
        double d = Pop();
        Push(0.0D - d);
    }

    private void clr() {
        this.st = new Stack();
    }

    private void minus() {
        double d1 = Pop();
        double d2 = Pop();
        Push(d2 - d1);
    }

    private void times() {
        double d1 = Pop();
        double d2 = Pop();
        Push(d2 * d1);
    }

    private void divide() {
        double d1 = Pop();
        double d2 = Pop();
        Push(d2 / d1);
    }

    private void del() {
        double d = Pop();
    }

    private void yx() {
        double d1 = Pop();
        double d2 = Pop();
        Push(Math.pow(d2, d1));
    }

    private void sqr() {
        double d = Pop();
        Push(d * d);
    }

    private void invert() {
        double d = Pop();
        Push(1.0D / d);
    }

    private void sqrt() {
        double d = Pop();
        Push(Math.sqrt(d));
    }

    private void power() {
        double d = Pop();
        Push(Math.pow(10.0D, d));
    }

    private void log() {
        double d = Pop();
        Push(Math.log(d) / Math.log(10.0D));
    }

    private void ln() {
        double d = Pop();
        Push(Math.log(d));
    }

    private void ex() {
        double d = Pop();
        Push(Math.pow(Math.E, d));
    }

    private void swap() {
        double d1 = Pop();
        double d2 = Pop();
        Push(d1);
        Push(d2);
    }

    private void xrty() {
        double d1 = Pop();
        double d2 = Pop();
        Push(Math.pow(d2, 1.0D / d1));
    }

    private void rand() {
        Push(Math.random());
    }

    private void percent() {
        double d1 = Pop();
        double d2 = Pop();
        Push(d1 / 100.0D * d2);
    }

    private void randomize() {
    }

    private void sin() {
        if (this.AngleMode == 1) {
            double d = Pop();
            d = d * 2.0D * Math.PI / 360.0D;
            d = Math.sin(d);
            Push(d);
        }
    }

    private void cos() {
        if (this.AngleMode == 1) {
            double d = Pop();
            d = d * 2.0D * Math.PI / 360.0D;
            d = Math.cos(d);
            Push(d);
        }
    }

    private void tan() {
        if (this.AngleMode == 1) {
            double d = Pop();
            d = d * 2.0D * Math.PI / 360.0D;
            d = Math.tan(d);
            Push(d);
        }
    }

    private void error(String paramString) {
    }

    private void plus() {
        double d1 = Pop();
        double d2 = Pop();
        Push(d1 + d2);
    }

    private double Peek() {
        if (this.st.empty()) {
            return 0.0D;
        }
        return ((Double) this.st.peek());
    }

    private void Push(double paramDouble) {
        BigDecimal bigDecimal = new BigDecimal(paramDouble);
        bigDecimal.setScale(12, 4);
        this.st.push(bigDecimal.doubleValue());
    }

    private double Pop() {
        if (this.st.empty()) {
            return 0.0D;
        }
        return ((Double) this.st.pop());
    }
}
