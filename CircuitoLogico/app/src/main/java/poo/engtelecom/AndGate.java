package poo.engtelecom;

import android.content.Context;

/**
 * Classe para representar graficamente uma porta lógica AND na tela. Nessa classe são guardadas as
 * coordenadas dos pinos de entrada e saída, bem como o identificador do Recurso drawble (imagem).
 */
public class AndGate extends LogicGate {

    private static final int sIMAGE = R.drawable.and;

    private static final int sOFFSETOUTPUTX = 45;
    private static final int sOFFSETOUTPUTY = 0;

    private static final int sOFFSETINPUTAX = 23;
    private static final int sOFFSETINPUTAY = 0;

    private static final int sOFFSETINPUTBX = 63;
    private static final int sOFFSETINPUTBY = 0;

    private int inputBX;
    private int inputBY;

    public AndGate(Context context, int coordX, int coordY) {
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

