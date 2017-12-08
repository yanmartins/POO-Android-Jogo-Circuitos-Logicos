package poo.engtelecom;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FasesActivity extends AppCompatActivity implements View.OnClickListener{

    Button fase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fases);

        fase = (Button) findViewById(R.id.fase01);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase02);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase03);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase04);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase05);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase06);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase07);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase08);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase09);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase10);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase11);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase12);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase13);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase14);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase15);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase16);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase17);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase18);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase19);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase20);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase21);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase22);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase23);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase24);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase25);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase26);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase27);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase28);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase29);
        fase.setOnClickListener(this);
        fase = (Button) findViewById(R.id.fase30);
        fase.setOnClickListener(this);
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
            case R.id.fase07:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE7","fase7.txt");
                startActivity(intent);
                break;
            case R.id.fase08:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE8","fase8.txt");
                startActivity(intent);
                break;
            case R.id.fase09:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE9","fase9.txt");
                startActivity(intent);
                break;
            case R.id.fase10:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE10","fase10.txt");
                startActivity(intent);
                break;
            case R.id.fase11:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE11","fase11.txt");
                startActivity(intent);
                break;
            case R.id.fase12:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE12","fase12.txt");
                startActivity(intent);
                break;
            case R.id.fase13:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE13","fase13.txt");
                startActivity(intent);
                break;
            case R.id.fase14:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE14","fase14.txt");
                startActivity(intent);
                break;
            case R.id.fase15:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE15","fase15.txt");
                startActivity(intent);
                break;
            case R.id.fase16:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE16","fase16.txt");
                startActivity(intent);
                break;
            case R.id.fase17:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE17","fase17.txt");
                startActivity(intent);
                break;
            case R.id.fase18:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE18","fase18.txt");
                startActivity(intent);
                break;
            case R.id.fase19:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE19","fase19.txt");
                startActivity(intent);
                break;
            case R.id.fase20:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE20","fase20.txt");
                startActivity(intent);
                break;
            case R.id.fase21:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE21","fase21.txt");
                startActivity(intent);
                break;
            case R.id.fase22:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE22","fase22.txt");
                startActivity(intent);
                break;
            case R.id.fase23:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE23","fase23.txt");
                startActivity(intent);
                break;
            case R.id.fase24:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE24","fase24.txt");
                startActivity(intent);
                break;
            case R.id.fase25:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE25","fase25.txt");
                startActivity(intent);
                break;
            case R.id.fase26:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE26","fase26.txt");
                startActivity(intent);
                break;
            case R.id.fase27:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE27","fase27.txt");
                startActivity(intent);
                break;
            case R.id.fase28:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE28","fase28.txt");
                startActivity(intent);
                break;
            case R.id.fase29:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE29","fase29.txt");
                startActivity(intent);
                break;
            case R.id.fase30:
                intent = new Intent(this, GameActivity.class);
                intent.putExtra("FASE30","fase30.txt");
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
