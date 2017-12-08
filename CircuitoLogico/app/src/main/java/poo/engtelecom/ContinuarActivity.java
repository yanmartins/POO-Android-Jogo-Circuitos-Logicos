package poo.engtelecom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ContinuarActivity extends AppCompatActivity {

    private TextView t1, t2, t3, t4;
    private EditText jogEscolhido;
    private Button continuar;
    private List<String> nomes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuar);

        String linha = null;
        try {
            FileInputStream fileInputStream = openFileInput("jogadores.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            try {
                while ((linha = bufferedReader.readLine()) != null) {
                    nomes.add(linha);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        t1 = (TextView) findViewById(R.id.jog1);
        t2 = (TextView) findViewById(R.id.jog2);
        t3 = (TextView) findViewById(R.id.jog3);
        t4 = (TextView) findViewById(R.id.jog4);

        if (nomes.size() == 4){
            t1.setText(nomes.get(0));
            t2.setText(nomes.get(1));
            t3.setText(nomes.get(2));
            t4.setText(nomes.get(3));
        }
        if (nomes.size() == 3){
            t1.setText(nomes.get(0));
            t2.setText(nomes.get(1));
            t3.setText(nomes.get(2));
        }
        if (nomes.size() == 2){
            t1.setText(nomes.get(0));
            t2.setText(nomes.get(1));
        }
        if (nomes.size() == 1){
            t1.setText(nomes.get(0));
        }
        //else {
        //    Toast toast = Toast.makeText(this, "Não existem jogadores cadastrados", Toast.LENGTH_LONG);
        //    toast.show();
        //    finish();

        //}
        jogEscolhido = (EditText) findViewById(R.id.jogEscolhido);
    }

    public void iniciarGameActivity(View view) {

        String linha = null;
        List<String> fases = new ArrayList<>();
        try {
            FileInputStream fileInputStream = openFileInput(jogEscolhido.getText() +".txt");
            System.out.println(fileInputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            try {
                while ((linha = bufferedReader.readLine()) != null) {
                    fases.add(linha);
                    System.out.println(linha);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, GameActivity.class);
        int i = fases.size();
        if (i == 0){
            Toast toast1 = Toast.makeText(this, "Digite um nome de jogador válido", Toast.LENGTH_LONG);
            toast1.show();
        }
        else {
            Toast toast = Toast.makeText(this, "Bom Jogo\n" + jogEscolhido.getText(), Toast.LENGTH_LONG);
            toast.show();
            String[] dados = fases.get(i - 1).toString().split(";");
            if (dados[0].contains("fase1.txt")) {
                intent.putExtra("FASE2", "fase2.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase2.txt")) {
                intent.putExtra("FASE3", "fase3.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase3.txt")) {
                intent.putExtra("FASE4", "fase4.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase4.txt")) {
                intent.putExtra("FASE5", "fase5.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase5.txt")) {
                intent.putExtra("FASE6", "fase6.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase6.txt")) {
                intent.putExtra("FASE7", "fase7.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase7.txt")) {
                intent.putExtra("FASE8", "fase8.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase8.txt")) {
                intent.putExtra("FASE9", "fase9.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase9.txt")) {
                intent.putExtra("FASE10", "fase10.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase10.txt")) {
                intent.putExtra("FASE11", "fase11.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase11.txt")) {
                intent.putExtra("FASE12", "fase12.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase12.txt")) {
                intent.putExtra("FASE13", "fase13.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase13.txt")) {
                intent.putExtra("FASE14", "fase14.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
            if (dados[0].contains("fase14.txt")) {
                intent.putExtra("FASE15", "fase15.txt");
                intent.putExtra("JOGADOR", jogEscolhido.getText().toString());
                startActivity(intent);
            }
        }



    }
}