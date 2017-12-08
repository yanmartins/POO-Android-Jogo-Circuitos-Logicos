package poo.engtelecom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NovoJogadorActivity extends AppCompatActivity {

    private EditText nome;
    private List<String> jogadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_jogador);
        nome = (EditText) findViewById(R.id.nome);
    }

    public void iniciarGameActivity(View view) {

        String linha = null;
        try {
            FileInputStream fileInputStream = openFileInput("jogadores.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            try {
                while ((linha = bufferedReader.readLine()) != null) {
                    jogadores.add(linha);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jogadores.size() == 4){
            Toast toast1 = Toast.makeText(this, "Limite de jogadores Atingido. Delete um para continuar", Toast.LENGTH_LONG);
            toast1.show();
            Intent intent = new Intent(this, ContinuarActivity.class);
            startActivity(intent);
        }else {

            Toast toast = Toast.makeText(this, "Bom Jogo\n" + nome.getText(), Toast.LENGTH_LONG);
            toast.show();

            String filename = String.valueOf(nome.getText() + ".txt");

            String filename1 = String.valueOf("jogadores.txt");

            FileOutputStream outputStream1 = null;
            try {
                outputStream1 = openFileOutput(filename1, MODE_APPEND);
                outputStream1.write((filename.substring(0, filename.length() - 4) + "\n").getBytes());
                outputStream1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileOutputStream outputStream = null;
            try {
                outputStream = openFileOutput(filename, MODE_APPEND);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("FASE1", "fase1.txt");
            intent.putExtra("JOGADOR", nome.getText().toString());
            startActivity(intent);
        }
    }

}

