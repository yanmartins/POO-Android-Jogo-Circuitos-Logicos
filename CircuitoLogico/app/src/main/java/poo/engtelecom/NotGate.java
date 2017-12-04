package poo.engtelecom;

import android.content.Context;

/**
 * Created by Yan Martins on 01/12/2017.
 */

public class NotGate extends LogicGate {

    private static final int sIMAGE = R.drawable.not;;

    private static final int sOFFSETOUTPUTX = 35;
    private static final int sOFFSETOUTPUTY = 7;

    private static final int sOFFSETINPUTAX = 35;
    private static final int sOFFSETINPUTAY = -3;

    private boolean segInA;
    private boolean segOut;

    public NotGate(Context context, int coordX, int coordY) {
        super(context, sIMAGE, coordX, coordY);

        outputX = x + sOFFSETOUTPUTX;
        outputY = y + sOFFSETOUTPUTY;

        inputAX = x + sOFFSETINPUTAX;
        inputAY = y + bitmap.getHeight() + sOFFSETINPUTAY;

        this.segInA = false;
        this.segOut = false;
    }


    public boolean isSegInA() {
        return segInA;
    }

    public void setSegInA(boolean segInA) {
        this.segInA = segInA;
    }

    public boolean isSegOut() {
        return segOut;
    }

    public void setSegOut(boolean segOut) {
        this.segOut = segOut;
    }

    public void logicaDaPorta(){
        if (isSegInA()) {
            setSegOut(false);
        }
        else if (!isSegInA()) {
            setSegOut(true);
        }
    }
}
