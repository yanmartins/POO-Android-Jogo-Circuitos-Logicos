package poo.engtelecom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * É tela principal do jogo onde deverão ser desenhadas as fases. Ou seja, ao carregar uma nova fase
 * de um arquivo texto, deve-se limpar a tela e desenhar todos os componentes (portas, conexões,
 * botões, etc.)
 */
public class GameView extends SurfaceView{

    private SurfaceHolder surfaceHolder;
    private int width; // largura do display
    private int height; // altura do display
    private Paint paint;

    // Os atributos abaixo são usados somente para representar um simples exemplo de como
    // instanciar e desenhar componentes em uma SurfaceView, bem como tratar um evento de toque na tela
    // e reagir ao mesmo, por exemplo, trocando a cor de uma conexão

    private int tamanhoDoSegmento;
    private Context context;

    private class Fio{
        int startX;
        int startY;
        int stopX;
        int stopY;
        boolean fioLigado;

        public Fio(int startX, int startY, int stopX, int stopY, boolean fioLigado) {
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
            this.fioLigado = fioLigado;
        }

        public int getStartX() {
            return startX;
        }

        public int getStartY() {

            return startY;
        }

        public int getStopX() {
            return stopX;
        }

        public int getStopY() {
            return stopY;
        }

        public boolean isFioLigado() {
            return fioLigado;
        }

        public void setFioLigado(boolean fioLigado) {
            this.fioLigado = fioLigado;
        }
    }

    private class Segmento{
        int startX;
        int startY;
        int stopX;
        int stopY;
        int tamanhoDoSegmentoY;
        int tamanhoDoSegmentoX;
        boolean segmentoLigado;

        public Segmento(int startX, int startY, int stopX, int stopY, boolean segmentoLigado) {
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
            this.segmentoLigado = segmentoLigado;
            this.tamanhoDoSegmentoY = (stopY-startY)/2;
            this.tamanhoDoSegmentoX = (stopX-startX);
        }

        public int getTamanhoDoSegmentoX() {
            return tamanhoDoSegmentoX;
        }

        public int getTamanhoDoSegmentoY() {
            return tamanhoDoSegmentoY;
        }

        public int getStartX() {
            return startX;
        }

        public int getStartY() {
            return startY;
        }

        public int getStopX() {
            return stopX;
        }

        public int getStopY() {
            return stopY;
        }

        public boolean isSegmentoLigado() {
            return segmentoLigado;
        }

        public void setSegmentoLigado(boolean segmentoLigado) {
            this.segmentoLigado = segmentoLigado;
        }
    }

    private List<Botao> botoes;
    private List<Fio> fios;
    private List<AndGate> portas;
    private List<Segmento> segmentos;

    public GameView(Context context, int width, int height) {
        super(context);
        this.context = context;
        this.width = width;
        this.height = height;
        surfaceHolder = getHolder();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setWillNotDraw(false);

        botoes = new ArrayList<Botao>();
        fios = new ArrayList<Fio>();
        portas = new ArrayList<AndGate>();
        segmentos = new ArrayList<Segmento>();

        criarPortas();
        criarBotoes();
        criarFios();
        criarSegmentos();
    }

    /**
     * Para tratar quando o usuário tocar na tela
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event){
        logicaDoJogo(event);
        desenhar();
        return super.onTouchEvent(event);
    }


    /**
     * Um exemplo estático para uma lógica do jogo. Nesse exemplo só é verificado se as coordenadas
     * do toque do usuário estão dentro de algum botão. Se o usuário tocar o botão1, então é
     * apresentado um exemplo de como mudar a cor de linha que representa uma conexão.
     *
     * @param event
     */
    private void logicaDoJogo(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (botoes.get(0).clicouNoBotao(x, y)){
            botoes.get(0).pressionar();
            segmentos.get(2).setSegmentoLigado(! segmentos.get(2).isSegmentoLigado());
        }

        if (botoes.get(1).clicouNoBotao(x, y)){
            botoes.get(1).pressionar();
            segmentos.get(3).setSegmentoLigado(! segmentos.get(3).isSegmentoLigado());
        }

        if (botoes.get(2).clicouNoBotao(x, y)){
            botoes.get(2).pressionar();
            segmentos.get(4).setSegmentoLigado(! segmentos.get(4).isSegmentoLigado());
        }

        if (botoes.get(3).clicouNoBotao(x, y)){
            botoes.get(3).pressionar();
            segmentos.get(5).setSegmentoLigado(! segmentos.get(5).isSegmentoLigado());
        }

        if(segmentos.get(2).isSegmentoLigado() && segmentos.get(3).isSegmentoLigado()){
            segmentos.get(0).setSegmentoLigado(true);
        }

        if(!segmentos.get(2).isSegmentoLigado() || !segmentos.get(3).isSegmentoLigado()){
            segmentos.get(0).setSegmentoLigado(false);
        }

        if(segmentos.get(4).isSegmentoLigado() && segmentos.get(5).isSegmentoLigado()){
            segmentos.get(1).setSegmentoLigado(true);
        }

        if(!segmentos.get(4).isSegmentoLigado() || !segmentos.get(5).isSegmentoLigado()){
            segmentos.get(1).setSegmentoLigado(false);
        }
        if(botoes.get(5).clicouNoBotao(x,y)){
            botoes.get(5).pressionarValidar();
            String mensagem = "Validar";

            Toast toast = Toast.makeText(context, mensagem, Toast.LENGTH_LONG);
            toast.show();

            //botoes.get(5).pressionarValidar();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        desenhar();
    }

    private void criarFios(){
        Fio fio1 = new Fio(portas.get(0).getInputAX(),portas.get(0).getInputAY(), (botoes.get(0).getBitmap().getWidth())/2, height-150, false);
        //Fio fio2 = new Fio(portas.get(1).getInputAX(),portas.get(1).getInputAY(),((botoes.get(1).getBitmap().getWidth())/2)+145, height-150, false);
        Fio fio3 = new Fio(portas.get(1).getInputBX(),portas.get(1).getInputBY(),((botoes.get(2).getBitmap().getWidth())/2)+290, height-150, false);

        //fios.add(fio1);
        //fios.add(fio2);
        //fios.add(fio3);
    }

    private void criarSegmentos(){
        Segmento segmento1 = new Segmento(portas.get(0).getInputAX(),portas.get(0).getInputAY(),
                portas.get(1).getOutputX(), portas.get(1).getOutputY(), false);

        Segmento segmento2 = new Segmento(portas.get(0).getInputBX(),portas.get(0).getInputBY(),
                portas.get(2).getOutputX(), portas.get(2).getOutputY(), false);

        Segmento segmento3 = new Segmento(portas.get(1).getInputAX(),portas.get(1).getInputAY(),
                ((botoes.get(1).getBitmap().getWidth())/2), height-150, false);

        Segmento segmento4 = new Segmento(portas.get(1).getInputBX(),portas.get(1).getInputBY(),
                ((botoes.get(2).getBitmap().getWidth())/2)+145, height-150, false);

        Segmento segmento5 = new Segmento(portas.get(2).getInputAX(),portas.get(2).getInputAY(),
                ((botoes.get(1).getBitmap().getWidth())/2)+290, height-150, false);

        Segmento segmento6 = new Segmento(portas.get(2).getInputBX(),portas.get(2).getInputBY(),
                ((botoes.get(1).getBitmap().getWidth())/2)+435, height-150, false);

        segmentos.add(segmento1);
        segmentos.add(segmento2);
        segmentos.add(segmento3);
        segmentos.add(segmento4);
        segmentos.add(segmento5);
        segmentos.add(segmento6);

    }

    private void criarBotoes(){
        Botao botao1 = new Botao(context, 0, height - 150);
        Botao botao2 = new Botao(context, 145, height - 150);
        Botao botao3 = new Botao(context, 290, height - 150);
        Botao botao4 = new Botao(context, 435, height - 150);
        Botao botao5 = new Botao(context, width - 140, height - 150);
        Botao botao6 = new Botao(context,1,width - 100,height - 1792);


        botoes.add(botao1);
        botoes.add(botao2);
        botoes.add(botao3);
        botoes.add(botao4);
        botoes.add(botao5);
        botoes.add(botao6);
    }

    private void criarPortas(){
        AndGate andGate = new AndGate(context, width/2-50, height/4);
        AndGate andGate2 = new AndGate(context, width/4-50, height/2);
        AndGate andGate3 = new AndGate(context, width-(width/4)-83, height/2);

        portas.add(andGate);
        portas.add(andGate2);
        portas.add(andGate3);
    }

    /**
     * Esse método deve ser chamado para atualizar a tela e redesenhar todos os componentes.
     * A presente implementação é só um exemplo estático e deveria ser completamente reescrito.
     */
    private void desenhar(){

        if (surfaceHolder.getSurface().isValid()){

            Canvas canvas = surfaceHolder.lockCanvas();

            // Escolhendo uma cor que foi definida nos Recursos XML (res/values/colors.xml)
            canvas.drawColor(getContext().getColor(R.color.branco));

            desenharPorta(canvas);
            desenharBotao(canvas);
            desenharFio(canvas);
            desenharSegmento(canvas);

            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void desenharSegmento(Canvas canvas){

        for(int i = 0; i < segmentos.size(); i++) {
            if (segmentos.get(i).isSegmentoLigado()) {
                paint.setColor(Color.BLUE);
            } else {
                paint.setColor(Color.BLACK);
            }
            paint.setStrokeWidth(9f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);

            int linhas[][] = new int[4][2]; // x, y

            linhas[0][0] = segmentos.get(i).getStartX();
            linhas[0][1] = segmentos.get(i).getStartY();

            linhas[1][0] = linhas[0][0];
            linhas[1][1] = linhas[0][1] + segmentos.get(i).getTamanhoDoSegmentoY();

            linhas[2][0] = linhas[1][0] + segmentos.get(i).getTamanhoDoSegmentoX();
            linhas[2][1] = linhas[1][1];

            linhas[3][0] = segmentos.get(i).getStopX();
            linhas[3][1] = segmentos.get(i).getStopY();

            Path p = new Path();
            p.moveTo(linhas[0][0], linhas[0][1]);
            for (int g = 1; g < linhas.length; g++) {
                p.lineTo(linhas[g][0], linhas[g][1]);
            }
            canvas.drawPath(p, paint);

            //canvas.drawLine(fios.get(i).getStartX(), fios.get(i).getStartY(), fios.get(i).getStopX(), fios.get(i).getStopY(), paint);
        }
    }

    private void desenharFio(Canvas canvas){
        for(int i = 0; i < fios.size(); i++) {
            if (fios.get(i).isFioLigado()) {
                paint.setColor(Color.BLUE);
            } else {
                paint.setColor(Color.BLACK);
            }
            paint.setStrokeWidth(9f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);

            canvas.drawLine(fios.get(i).getStartX(), fios.get(i).getStartY(), fios.get(i).getStopX(), fios.get(i).getStopY(), paint);
        }
    }

    private void desenharBotao(Canvas canvas){
        for(int i = 0; i < botoes.size(); i++) {
            canvas.drawBitmap(botoes.get(i).getBitmap(), botoes.get(i).getX(), botoes.get(i).getY(), paint);
        }
    }

    private void desenharPorta(Canvas canvas){
        for(int i = 0; i < portas.size(); i++) {
            canvas.drawBitmap(portas.get(i).getBitmap(), portas.get(i).getX(), portas.get(i).getY(), paint);
        }
    }
}
