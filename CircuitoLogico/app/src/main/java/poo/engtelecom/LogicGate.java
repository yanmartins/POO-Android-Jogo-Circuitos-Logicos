package poo.engtelecom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Essa classe abstrata contempla as informações presentes em todas as portas lógicas que serão
 * usadas no jogo. Toda porta lógica possui uma saída e pelo menos 1 entrada e para essas é necessário
 * conhecer suas coordenadas (X,Y) na tela, pois serão usadas para desenhas as linhas de conexão entre
 * as portas lógicas em um cenário.
 */
public abstract class LogicGate extends Componente{

    // Coordenadas nas tela da saída
    protected int outputX;
    protected int outputY;

    // Coordenadas na tela da primeira entrada
    protected int inputAX;
    protected int inputAY;

    public LogicGate(Context context, int drawableResource, int x, int y) {
        super(context, drawableResource, x, y);
    }

    public int getOutputX() {
        return outputX;
    }

    public int getOutputY() {
        return outputY;
    }

    public int getInputAX() {
        return inputAX;
    }

    public int getInputAY() {
        return inputAY;
    }
}
