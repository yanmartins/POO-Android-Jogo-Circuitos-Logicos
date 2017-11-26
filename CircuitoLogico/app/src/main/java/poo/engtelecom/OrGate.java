package poo.engtelecom;

import android.content.Context;

import poo.engtelecom.LogicGate;
import poo.engtelecom.R;

/**
 * Created by aluno on 24/11/17.
 */

public class OrGate extends LogicGate {

    private static final int sIMAGE = R.drawable.or;

    private static final int sOFFSETOUTPUTX = 45;
    private static final int sOFFSETOUTPUTY = 0;

    private static final int sOFFSETINPUTAX = 23;
    private static final int sOFFSETINPUTAY = 0;

    private static final int sOFFSETINPUTBX = 63;
    private static final int sOFFSETINPUTBY = 0;

    private int inputBX;
    private int inputBY;


    public OrGate(Context context, int coordX, int coordY) {
        super(context, sIMAGE, coordX, coordY);

        outputX = x + sOFFSETOUTPUTX;
        outputY = y + sOFFSETOUTPUTY;

        inputAX = x + sOFFSETINPUTAX;
        inputAY = y + bitmap.getHeight() + sOFFSETINPUTAY;

        inputBX = x + sOFFSETINPUTBX;
        inputBY = y + bitmap.getHeight() + sOFFSETINPUTBY;
    }

    public int getInputBX() {
        return inputBX;
    }

    public int getInputBY() {
        return inputBY;
    }
}
