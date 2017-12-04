package poo.engtelecom;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FasesActivity extends AppCompatActivity implements View.OnClickListener{

    Button fase1, fase2, fase3, fase4, fase5, fase6, fase7, fase8, fase9, fase10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fases);

        fase1 = (Button) findViewById(R.id.fase01);
        fase1.setOnClickListener(this);
        fase2 = (Button) findViewById(R.id.fase02);
        fase2.setOnClickListener(this);
        fase3 = (Button) findViewById(R.id.fase03);
        fase3.setOnClickListener(this);
        fase4 = (Button) findViewById(R.id.fase04);
        fase4.setOnClickListener(this);
        fase5 = (Button) findViewById(R.id.fase05);
        fase5.setOnClickListener(this);
        fase6 = (Button) findViewById(R.id.fase06);
        fase6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.fase01:
                Intent intent = new Intent(this,GameActivity.class);
                intent.putExtra("FASE1","fase1.txt");
                startActivity(intent);
                break;

            case R.id.fase02:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE2","fase2.txt");
                startActivity(intent);
                break;

            case R.id.fase03:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE3","fase3.txt");
                startActivity(intent);
                break;
            case R.id.fase04:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE4","fase4.txt");
                startActivity(intent);
                break;
            case R.id.fase05:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE5","fase5.txt");
                startActivity(intent);
                break;
            case R.id.fase06:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE6","fase6.txt");
                startActivity(intent);
                break;
        }
    }

    public void iniciarGameActivity(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyleGreenAndYellow);
        builder.setMessage("Deseja voltar ao menu inicial?")
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
