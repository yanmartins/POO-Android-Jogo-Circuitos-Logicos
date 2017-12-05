package poo.engtelecom;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * É tela principal do jogo onde deverão ser desenhadas as fases. Ou seja, ao carregar uma nova fase
 * de um arquivo texto, deve-se limpar a tela e desenhar todos os componentes (portas, conexões,
 * botões, etc.)
 */
public class GameView extends SurfaceView {

    private SurfaceHolder surfaceHolder;
    private int width; // largura do display
    private int height; // altura do display
    private String nomeFase; // fase desejada
    private Paint paint;

    // Os atributos abaixo são usados somente para representar um simples exemplo de como
    // instanciar e desenhar componentes em uma SurfaceView, bem como tratar um evento de toque na tela
    // e reagir ao mesmo, por exemplo, trocando a cor de uma conexão

    private int tamanhoDoSegmento;
    private Context context;
    private GameActivity gameActivity;

    private class Segmento {
        int startX;
        int startY;
        int stopX;
        int stopY;
        int tamanhoDoSegmentoY;
        int tamanhoDoSegmentoX;
        boolean segmentoLigado;
        boolean modoFacil;

        boolean segmentoLigadoOculto;

        int portaAssociadaOrig;
        int portaAssociadaDest;
        String tipoDaPortaOrig;
        String tipoDaPortaDest;
        char terminalAssociado;

        public Segmento(int startX, int startY, int stopX, int stopY,
                        boolean modoFacil, String tipoDaPortaOrig, String tipoDaPortaDest,
                        int portaAssociadaOrig, int portaAssociadaDest,
                        char terminalAssociado) {
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
            this.segmentoLigado = false;
            this.tamanhoDoSegmentoY = (stopY - startY) / 2;
            this.tamanhoDoSegmentoX = (stopX - startX);
            this.modoFacil = modoFacil;
            this.segmentoLigadoOculto = false;
            this.portaAssociadaOrig = portaAssociadaOrig;
            this.portaAssociadaDest = portaAssociadaDest;
            this.terminalAssociado = terminalAssociado;
            this.tipoDaPortaDest = tipoDaPortaDest;
            this.tipoDaPortaOrig = tipoDaPortaOrig;
        }

        public Segmento(int startX, int startY, int stopX, int stopY,
                        boolean modoFacil, String tipoDaPortaOrig, String tipoDaPortaDest,
                        int portaAssociadaOrig, int portaAssociadaDest) {
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
            this.segmentoLigado = false;
            this.tamanhoDoSegmentoY = (stopY - startY) / 2;
            this.tamanhoDoSegmentoX = (stopX - startX);
            this.modoFacil = modoFacil;
            this.segmentoLigadoOculto = false;
            this.portaAssociadaOrig = portaAssociadaOrig;
            this.portaAssociadaDest = portaAssociadaDest;
            this.tipoDaPortaDest = tipoDaPortaDest;
            this.tipoDaPortaOrig = tipoDaPortaOrig;

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

        public boolean isSegmentoLigadoOculto() {
            return segmentoLigadoOculto;
        }

        public boolean isSegmentoLigado() {
            return segmentoLigado;
        }

        public void setSegmentoLigado(boolean segmentoLigado) {

            if (modoFacil) {
                this.segmentoLigado = segmentoLigado;
            }
            this.segmentoLigadoOculto = segmentoLigado;

            if (tipoDaPortaDest.equals("not")) {
                portasNot.get(portaAssociadaDest).setSegInA(segmentoLigado);
            }
            else {
                if (terminalAssociado == 'a') {
                    portas.get(portaAssociadaDest).setSegInA(segmentoLigado);
                } else portas.get(portaAssociadaDest).setSegInB(segmentoLigado);
            }
        }

        public void logicaDoSegmento() {

            if (tipoDaPortaOrig.equals("not")) {
                if (portasNot.get(portaAssociadaOrig).isSegOut()) {
                    setSegmentoLigado(true);
                } else setSegmentoLigado(false);
            }

            else  {
                if (portas.get(portaAssociadaOrig).isSegOut()) {
                    setSegmentoLigado(true);
                } else setSegmentoLigado(false);
            }
        }
    }

    private class SegmentoBotao {
        int startX;
        int startY;
        int stopX;
        int stopY;
        int tamanhoDoSegmentoY;
        int tamanhoDoSegmentoX;
        boolean segmentoLigado;
        boolean modoFacil;
        boolean segmentoLigadoOculto;
        String tipoDaPortaDest;
        char terminalAssociado;
        int portaAssociadaDest;


        public SegmentoBotao(int startX, int startY, int stopX, int stopY,
                             boolean modoFacil, String tipoDaPortaDest, int portaAssociadaDest,
                             char terminalAssociado) {
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
            this.segmentoLigado = false;
            this.tamanhoDoSegmentoY = (stopY - startY) / 2;
            this.tamanhoDoSegmentoX = (stopX - startX);
            this.modoFacil = modoFacil;
            this.segmentoLigadoOculto = false;
            this.portaAssociadaDest = portaAssociadaDest;
            this.terminalAssociado = terminalAssociado;
            this.tipoDaPortaDest = tipoDaPortaDest;
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

        public boolean isSegmentoLigadoOculto() {
            return segmentoLigadoOculto;
        }

        public boolean isSegmentoLigado() {
            return segmentoLigado;
        }

        public void setSegmentoLigado(boolean segmentoLigado) {

            if (modoFacil) {
                this.segmentoLigado = segmentoLigado;
            }

            this.segmentoLigadoOculto = segmentoLigado;

            if (tipoDaPortaDest.equals("not")) {
                portasNot.get(portaAssociadaDest).setSegInA(segmentoLigado);
            }
            else {
                if (terminalAssociado == 'a') {
                    portas.get(portaAssociadaDest).setSegInA(segmentoLigado);

                } else portas.get(portaAssociadaDest).setSegInB(segmentoLigado);
            }
        }
    }

    private List<Botao> botoes;
    private List<NotGate> portasNot;
    private List<SegmentoBotao> segmentoBotoes;
    private List<LogicGate2> portas;
    private List<Segmento> segmentos;

    private Botao botaoValidar;

    private int toquesNaTela;
    private int pontos = 100;
    private int MAXToques;
    private int reprovacoes;


    public GameView(Context context, int width, int height, String nomeFase,GameActivity gameActivity) throws IOException {

            super(context);
            this.context = context;
            this.gameActivity = gameActivity;
            this.width = width;
            this.height = height;
            this.nomeFase = nomeFase;
            this.gameActivity = gameActivity;
            surfaceHolder = getHolder();
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            setWillNotDraw(false);

            botoes = new ArrayList<Botao>();
            portasNot = new ArrayList<NotGate>();
            portas = new ArrayList<LogicGate2>();

            segmentos = new ArrayList<Segmento>();
            segmentoBotoes = new ArrayList<SegmentoBotao>();

            this.botaoValidar = new Botao(context, 1, width - 120, height - 1780, 0);

            try {
                carregaFase(nomeFase);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void setMAXToques(int MAXToques) {
        this.MAXToques = MAXToques;
    }

    /**
     * Para tratar quando o usuário tocar na tela
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
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

        for (int i = 0; i < botoes.size(); i++) {
            if (botoes.get(i).clicouNoBotao(x, y)) {
                toquesNaTela++;
                System.out.println("Tocou: " + toquesNaTela);
                botoes.get(i).pressionar();
                segmentoBotoes.get(botoes.get(i).getSegmentoAssociado()).setSegmentoLigado(!segmentoBotoes.get(botoes.get(i).getSegmentoAssociado()).isSegmentoLigadoOculto());
            }
        }

        // As lógicas são realizadas três vezes devido a falhas
        for (int g = 0; g < 3; g++) {
            for (int w = 0; w < portas.size(); w++) {
                portas.get(w).logicaDaPorta();
            }
            for (int w = 0; w < portasNot.size(); w++) {
                portasNot.get(w).logicaDaPorta();
            }
            for (int j = 0; j < segmentos.size(); j++) {
                segmentos.get(j).logicaDoSegmento();
            }
        }

        if (botaoValidar.clicouNoBotao(x, y)) {
            botaoValidar.pressionarValidar();
            String mensagem = "Validando...";
            Toast toast = Toast.makeText(context, mensagem, Toast.LENGTH_SHORT);
            toast.show();
            validacaoDaFase();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        desenhar();
    }

    /**
     * PORTA; TIPO; X; Y
     * BOTAO; X; segmentoASSOCIADO
     *
     */
    //SEGMENTO; BOTAO; intPORTA; tipoPORTA; terminal; dificuldade; botaoAssociado

    //SEGMENTO; COMUM; portaDestino; terminal; intPortaDest; portaOrigem; intPortaOrigem; dificuldade"

    public void carregaFase(String nomeFase) throws IOException {
        AssetManager assetManager = getResources().getAssets();
        InputStream inputStream;
        inputStream = assetManager.open(nomeFase);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String ler;
        String[] vetLinha;
        try {
            //ler = bufferedReader.readLine();
            while ((ler = bufferedReader.readLine()) != null) {
                vetLinha = ler.split(";");
                if (vetLinha[0].equals("porta")) {
                    criarPortas(vetLinha);
                }
                if (vetLinha[0].equals("botao")) {
                    criarBotoes(vetLinha);
                }
                if (vetLinha[0].equals("segmento")) {
                    criarSegmentos(vetLinha);
                }
                if(vetLinha[0].equals("fase")){
                    setMAXToques(Integer.parseInt(vetLinha[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void criarSegmentos(String[] v) {

        if(v[1].equals("comum")) {
            if (v[3].charAt(0) == 'a') {
                Segmento segmento = new Segmento(portas.get(Integer.parseInt(v[4])).getInputAX(), portas.get(Integer.parseInt(v[4])).getInputAY(),
                        portas.get(Integer.parseInt(v[6])).getOutputX(), portas.get(Integer.parseInt(v[6])).getOutputY(),
                        Boolean.parseBoolean(v[7]), v[5], v[2], Integer.parseInt(v[6]), Integer.parseInt(v[4]), 'a');
                segmentos.add(segmento);
            } else {
                Segmento segmento = new Segmento(portas.get(Integer.parseInt(v[4])).getInputBX(), portas.get(Integer.parseInt(v[4])).getInputBY(),
                        portas.get(Integer.parseInt(v[6])).getOutputX(), portas.get(Integer.parseInt(v[6])).getOutputY(),
                        Boolean.parseBoolean(v[7]), v[5], v[2], Integer.parseInt(v[6]), Integer.parseInt(v[4]), 'b');
                segmentos.add(segmento);
            }

        }

        else if(v[1].equals("botao")){
            SegmentoBotao segBotao;

            if (v[4].charAt(0) == 'a') {

                segBotao = new SegmentoBotao(portas.get(Integer.parseInt(v[2])).getInputAX(), portas.get(Integer.parseInt(v[2])).getInputAY(),
                        ((botoes.get(0).getBitmap().getWidth()) / 2 + (botoes.get(Integer.parseInt(v[6])).getX())), height - 150,  Boolean.parseBoolean(v[5]), v[3], Integer.parseInt(v[2]), 'a');
                segmentoBotoes.add(segBotao);
            } else{
                segBotao = new SegmentoBotao(portas.get(Integer.parseInt(v[2])).getInputBX(), portas.get(Integer.parseInt(v[2])).getInputBY(),
                        ((botoes.get(0).getBitmap().getWidth()) / 2 + (botoes.get(Integer.parseInt(v[6])).getX())), height - 150,  Boolean.parseBoolean(v[5]), v[3], Integer.parseInt(v[2]), 'b');
                segmentoBotoes.add(segBotao);
            }
        }
    }

    private void criarBotoes(String[] v) {
        Botao botao = new Botao(context, (width / 100)*(Integer.parseInt(v[1])), height - 150, Integer.parseInt(v[2]));
        botoes.add(botao);
    }

    private void criarPortas(String[] v) {
        if(v[1].equals("and")){
            AndGate and = new AndGate(context, width / 100 * (Integer.parseInt(v[2])), (height/100)*(Integer.parseInt(v[3])));
            portas.add(and);
        }
        if(v[1].equals("or")){
            OrGate or = new OrGate(context, width / 100 * (Integer.parseInt(v[2])), (height/100)*(Integer.parseInt(v[3])));
            portas.add(or);
        }
        if(v[1].equals("xor")){
            XorGate xor = new XorGate(context, width / 100 * (Integer.parseInt(v[2])), (height/100)*(Integer.parseInt(v[3])));
            portas.add(xor);
        }
        if(v[1].equals("not")){
            NotGate not = new NotGate(context, width / 100 * (Integer.parseInt(v[2])), (height/100)*(Integer.parseInt(v[3])));
            portasNot.add(not);
        }
    }

    /**
     * Esse método deve ser chamado para atualizar a tela e redesenhar todos os componentes.
     * A presente implementação é só um exemplo estático e deveria ser completamente reescrito.
     */
    private void desenhar() {

        if (surfaceHolder.getSurface().isValid()) {

            Canvas canvas = surfaceHolder.lockCanvas();

            // Escolhendo uma cor que foi definida nos Recursos XML (res/values/colors.xml)
            canvas.drawColor(getContext().getColor(R.color.branco));

            desenharBotaoValidar(canvas);
            desenharPorta(canvas);
            desenharBotao(canvas);
            desenharSegmentoBotao(canvas);
            desenharSegmento(canvas);

            System.out.println("Botoes: " + botoes.size());
            System.out.println("Segmentos bot: " + segmentoBotoes.size());
            System.out.println("Segmentos: "+segmentos.size());
            System.out.println("Portas: "+ portas.size());
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void desenharSegmentoBotao(Canvas canvas) {

        for (int i = 0; i < segmentoBotoes.size(); i++) {
            if (segmentoBotoes.get(i).isSegmentoLigado()) {
                paint.setColor(Color.BLUE);
            } else {
                paint.setColor(Color.BLACK);
            }

            paint.setStrokeWidth(5f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);

            int linhas[][] = new int[4][2]; // x, y

            linhas[0][0] = segmentoBotoes.get(i).getStartX();
            linhas[0][1] = segmentoBotoes.get(i).getStartY();

            linhas[1][0] = linhas[0][0];
            linhas[1][1] = linhas[0][1] + segmentoBotoes.get(i).getTamanhoDoSegmentoY();

            linhas[2][0] = linhas[1][0] + segmentoBotoes.get(i).getTamanhoDoSegmentoX();
            linhas[2][1] = linhas[1][1];

            linhas[3][0] = segmentoBotoes.get(i).getStopX();
            linhas[3][1] = segmentoBotoes.get(i).getStopY();

            Path p = new Path();
            p.moveTo(linhas[0][0], linhas[0][1]);
            for (int g = 1; g < linhas.length; g++) {
                p.lineTo(linhas[g][0], linhas[g][1]);
            }
            canvas.drawPath(p, paint);
        }
    }

    private void desenharSegmento(Canvas canvas) {

        for (int i = 0; i < segmentos.size(); i++) {
            if (segmentos.get(i).isSegmentoLigado()) {
                paint.setColor(Color.BLUE);
            } else {
                paint.setColor(Color.BLACK);
            }
            paint.setStrokeWidth(5f);
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
        }
    }

    private void desenharBotao(Canvas canvas) {
        for (int i = 0; i < botoes.size(); i++) {
            canvas.drawBitmap(botoes.get(i).getBitmap(), botoes.get(i).getX(), botoes.get(i).getY(), paint);
        }
    }

    private void desenharPorta(Canvas canvas) {

        for (int i = 0; i < portasNot.size(); i++) {
            canvas.drawBitmap(portasNot.get(i).getBitmap(), portasNot.get(i).getX(), portasNot.get(i).getY(), paint);
        }

        for (int i = 0; i < portas.size(); i++) {
            canvas.drawBitmap(portas.get(i).getBitmap(), portas.get(i).getX(), portas.get(i).getY(), paint);
        }
    }

    private void desenharBotaoValidar(Canvas canvas) {
        canvas.drawBitmap(botaoValidar.getBitmap(), botaoValidar.getX(), botaoValidar.getY(), paint);
    }

    private void validacaoDaFase() {
        /**
         * QUANTIDADE DE SEGMENTOS PARA VALIDAÇÃO
         * VERIFICAR SE TODOS ESTÃO LIGADOS
         */
        String mensagem = null;
            if (portas.get(0).isSegOut()) {

                mensagem = "CIRCUITO APROVADO 🎉\n" +
                        "Toques: " + toquesNaTela + "\n" +
                        "Pontuação: " + calculaPontuacao();
                int x = calculaPontuacao();
                gameActivity.showDialogFimdeFase(mensagem,x, nomeFase);

//            Toast toast = Toast.makeText(context, mensagem, Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.CENTER, 0, 0);
//            toast.show();
            } else {
                mensagem = "CIRCUITO REPROVADO 😭\n" +
                        "-10 pontos";
//            Toast toast = Toast.makeText(context, mensagem, Toast.LENGTH_LONG);
                reprovacoes++;
//            toast.show();
                gameActivity.showDialogFaseReprovada(mensagem);
                botaoValidar.pressionarValidar();
            }

        }


    private int calculaPontuacao() {
        int pontoDeToque;
        pontoDeToque = toquesNaTela - MAXToques;
        pontos = pontos - pontoDeToque*5 - reprovacoes*10;
        return pontos;
    }
}
