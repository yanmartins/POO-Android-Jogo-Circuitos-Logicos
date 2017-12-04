package poo.engtelecom;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ScoreActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

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
        TextView ponto5 = (TextView) findViewById(R.id.textViewPonto5);


        // Obtendo os recordes que já foram salvos. Se não tiver recorde salvo ainda, então retorna 0
        ponto1.setText(String.valueOf(sharedPreferences.getInt( "ponto1", 0)));
        ponto2.setText(String.valueOf(sharedPreferences.getInt( "ponto2", 0)));
        ponto3.setText(String.valueOf(sharedPreferences.getInt( "ponto3", 0)));
        ponto4.setText(String.valueOf(sharedPreferences.getInt( "ponto4", 0)));
        ponto5.setText(String.valueOf(sharedPreferences.getInt( "ponto5", 0)));

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
