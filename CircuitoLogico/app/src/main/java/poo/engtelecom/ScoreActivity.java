package poo.engtelecom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScoreActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private List<String> jogadores = new ArrayList<>();
    private String[] jogadoresPontos;
    private List<String> ranking = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Veja mais detalhes sobre o funcionamento de SharedPreferences no guia oficial do Android
        // https://developer.android.com/training/basics/data-storage/shared-preferences.html?hl=pt-br

        sharedPreferences = getApplicationContext().getSharedPreferences("RecordesDB", Context.MODE_PRIVATE);

        TextView ponto1 = (TextView) findViewById(R.id.textViewPonto1);
        TextView ponto2 = (TextView) findViewById(R.id.textViewPonto2);
        TextView ponto3 = (TextView) findViewById(R.id.textViewPonto3);
        TextView ponto4 = (TextView) findViewById(R.id.textViewPonto4);

        String linha = null;
        try {
            FileInputStream fileInputStream = openFileInput("jogadores.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            try {
                while ((linha = bufferedReader.readLine()) != null) {
                    jogadores.add(linha);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0 ; i < jogadores.size() ; i++ ) {
            int pontos = 0;
            String fase = null;
            System.out.println(jogadores.get(i));
            FileInputStream fileInputStream1 = null;
            try {
                fileInputStream1 = openFileInput(jogadores.get(i) + ".txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            InputStreamReader inputStreamReader1 = new InputStreamReader(fileInputStream1);
            BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader1);
            try {
                while ((linha = bufferedReader1.readLine()) != null) {
                    jogadoresPontos = linha.split(";");
                    pontos += Integer.parseInt(jogadoresPontos[1]);
                    fase = jogadoresPontos[0].substring(4,jogadoresPontos[0].length()-4);
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String pontuacao =(jogadores.get(i)+ ",fase: "+fase+", Pontuação:"+ String.valueOf(pontos));
            ranking.add(pontuacao);
        }

        for(int i = 0 ; i < ranking.size() ; i++ ) {
            System.out.println("LISTA RANKING  "+ranking.get(i).toString());
            System.out.println(ranking.size());
        }

        if (ranking.size() == 4){
            ponto1.setText(ranking.get(0).toString());
            ponto2.setText(ranking.get(1).toString());
            ponto3.setText(ranking.get(2).toString());
            ponto4.setText(ranking.get(3).toString());
        }
        if (ranking.size() == 3){
            ponto1.setText(ranking.get(0).toString());
            ponto2.setText(ranking.get(1).toString());
            ponto3.setText(ranking.get(2).toString());
            ponto4.setText(String.valueOf(sharedPreferences.getInt("ponto4", 0)));
        }
        if (ranking.size() == 2){
            ponto1.setText(ranking.get(0).toString());
            System.out.println(ranking.get(0));
            ponto2.setText(ranking.get(1).toString());
            ponto3.setText(String.valueOf(sharedPreferences.getInt("ponto3", 0)));
            ponto4.setText(String.valueOf(sharedPreferences.getInt("ponto4", 0)));
        }
        if (ranking.size() == 1){
            ponto1.setText(ranking.get(0).toString());
            ponto2.setText(String.valueOf(sharedPreferences.getInt("ponto2", 0)));
            ponto3.setText(String.valueOf(sharedPreferences.getInt("ponto3", 0)));
            ponto4.setText(String.valueOf(sharedPreferences.getInt("ponto4", 0)));
        }
        if (ranking.size() == 0){
            // Obtendo os recordes que já foram salvos. Se não tiver recorde salvo ainda, então retorna 0
            ponto1.setText(String.valueOf(sharedPreferences.getInt("ponto1", 0)));
            ponto2.setText(String.valueOf(sharedPreferences.getInt("ponto2", 0)));
            ponto3.setText(String.valueOf(sharedPreferences.getInt("ponto3", 0)));
            ponto4.setText(String.valueOf(sharedPreferences.getInt("ponto4", 0)));
            //ponto5.setText(String.valueOf(sharedPreferences.getInt( "ponto5", 0)));
        }
    }

    /**
     * Esse método é só um exemplo de como salvar recordes usando a API SharedPreferences.
     * Nesse exemplo sempre será gerado um novo valor para colocar na 1a. posição do recorde.
     *
     * No jogo real, aqui não seria o local para salvar recordes
     * @param view
     */
    public void gerarRecordesAleatorios(View view){
        Random r = new Random();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        int ponto = r.nextInt(100);

        editor.putInt("ponto1", ponto);

        editor.commit();

        // atualizando o textview
        TextView ponto1 = (TextView) findViewById(R.id.textViewPonto1);
        ponto1.setText(String.valueOf(sharedPreferences.getInt( "ponto1", 0)));



    }
}
