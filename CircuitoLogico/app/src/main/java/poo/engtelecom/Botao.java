package poo.engtelecom;

import android.content.Context;


/**
 * Classe para representar um push button.
 */
public class Botao extends Componente {


    // true para indicar que o botão está pressionado
    private boolean pressionado;
    private boolean validarPress;
    private int segmentoAssociado;
    private int interrogacao;



    public Botao(Context context, int x, int y, int segmentoAssociado) {
        super(context, R.drawable.desativado, x, y);
        pressionado = false;
        this.segmentoAssociado = segmentoAssociado;
    }

    public Botao(Context context, int drawableResource, int x, int y, int segmentoAssociado) {
        super(context, R.drawable.offvalidar, x, y);
        validarPress = false;
    }

    public Botao(Context context, int drawableResource, int x, int y,int segmentoAssociado,int interrogacao) {
        super(context, R.drawable.interrogacao, x, y);
        validarPress = false;
    }


    /**
     * Troca a imagem do botão de acordo com seu estado
     */
    public void pressionar(){
        if (pressionado){
            this.setBitmap(R.drawable.desativado);
        }else {
            this.setBitmap(R.drawable.ativado);
        }
        pressionado = ! pressionado;
    }

    public void pressionarValidar(){
        if (pressionado){
            this.setBitmap(R.drawable.offvalidar);
        }else {
            this.setBitmap(R.drawable.onvalidar);
        }
        pressionado = ! pressionado;
    }

    public int getSegmentoAssociado() {
        return segmentoAssociado;
    }

    /**
     * Um exemplo de como verificar se o toque do usuário na tela foi dentro da área onde o
     * botão está desenhado. Esse exemplo funciona bem se o botão for um retângulo. Se a forma do botão
     * for uma elipse, talvez então seria necessário pensar em outra solução.
     *
     * @param px - coordenada X do toque do usuário na tela
     * @param py - coordenada Y do toque do usuário na tela
     * @return retorna true se estiver dentro da área do botão
     */
    public boolean clicouNoBotao(int px, int py){

        // obtendo largura e altura da imagem do botão
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        return ((px > this.x && px < (this.x + width))
                && (py > this.y && py < (this.y + height))) ? true : false;

    }

}
