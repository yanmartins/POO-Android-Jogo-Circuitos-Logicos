package poo.engtelecom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NovoJogadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_jogador);
    }

    public void iniciarFasesActivity(View view){
        Intent intent = new Intent(this, FasesActivity.class);
        startActivity(intent);
    }
}
