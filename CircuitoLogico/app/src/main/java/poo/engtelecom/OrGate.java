package poo.engtelecom;

import android.content.Context;

/**
 * Created by aluno on 24/11/17.
 */

public class OrGate extends LogicGate2 {

    private static final int sIMAGE = R.drawable.or;

    private static final int sOFFSETOUTPUTX = 45;
    private static final int sOFFSETOUTPUTY = 0;

    private static final int sOFFSETINPUTAX = 23;
    private static final int sOFFSETINPUTAY = -5;

    private static final int sOFFSETINPUTBX = 63;
    private static final int sOFFSETINPUTBY = -5;

    private int inputBX;
    private int inputBY;

    private boolean segInA;
    private boolean segInB;
    private boolean segOut;

    public OrGate(Context context, int coordX, int coordY) {
        super(context, sIMAGE, coordX, coordY);

        outputX = x + sOFFSETOUTPUTX;
        outputY = y + sOFFSETOUTPUTY;

        inputAX = x + sOFFSETINPUTAX;
        inputAY = y + bitmap.getHeight() + sOFFSETINPUTAY;

        inputBX = x + sOFFSETINPUTBX;
        inputBY = y + bitmap.getHeight() + sOFFSETINPUTBY;

        this.segInA = false;
        this.segInB = false;
        this.segOut = false;
    }

    public int getInputBX() {
        return inputBX;
    }

    public int getInputBY() {
        return inputBY;
    }

    public boolean isSegInA() {
        return segInA;
    }

    public void setSegInA(boolean segInA) {
        this.segInA = segInA;
    }

    public boolean isSegInB() {
        return segInB;
    }

    public void setSegInB(boolean segInB) {
        this.segInB = segInB;
    }

    public boolean isSegOut() {
        return segOut;
    }

    public void setSegOut(boolean segOut) {
        this.segOut = segOut;
    }

    public void logicaDaPorta(){
        if (isSegInA() || isSegInB()) {
            setSegOut(true);
        }
        else if (!isSegInA() && !isSegInB()) {
            setSegOut(false);
        }
    }
}
