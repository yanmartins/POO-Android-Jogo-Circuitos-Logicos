package poo.engtelecom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;

public class NovoJogadorActivity extends AppCompatActivity {

    private EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_jogador);
        nome = (EditText) findViewById(R.id.nome);
    }

    public void iniciarGameActivity(View view) {

        Toast toast = Toast.makeText(this, "Bom Jogo\n" + nome.getText(), Toast.LENGTH_LONG);
        toast.show();

        String filename = String.valueOf(nome.getText() + ".txt");
        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(filename, MODE_APPEND);
            //outputStream.write((nome.getText() + "\n").getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename1 = String.valueOf("jogadores.txt");
        FileOutputStream outputStream1 = null;
        try {
            outputStream1 = openFileOutput(filename1, MODE_APPEND);
            outputStream1.write((filename.substring(0,filename.length() - 4) + "\n").getBytes());
            outputStream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("FASE1", "fase1.txt");
        intent.putExtra("JOGADOR",nome.getText().toString());
        startActivity(intent);
    }
}
