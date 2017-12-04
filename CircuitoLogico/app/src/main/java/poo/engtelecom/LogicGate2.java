package poo.engtelecom;

import android.content.Context;

/**
 * Created by Yan Martins on 02/12/2017.
 */

public class LogicGate2 extends LogicGate {

    private int inputBX;
    private int inputBY;
    private boolean segInA;
    private boolean segInB;
    private boolean segOut;

    public LogicGate2(Context context, int drawableResource, int x, int y) {
        super(context, drawableResource, x, y);
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
