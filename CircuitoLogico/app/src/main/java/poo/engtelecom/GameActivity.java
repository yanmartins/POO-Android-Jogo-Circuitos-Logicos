package poo.engtelecom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fase = null;
        Bundle bundle = getIntent().getExtras();
        if(bundle.containsKey("FASE1")){
            fase = bundle.getString("FASE1");
        }
        if(bundle.containsKey("FASE2")){
            fase = bundle.getString("FASE2");
        }
        if(bundle.containsKey("FASE3")){
            fase = bundle.getString("FASE3");
        }
        if(bundle.containsKey("FASE4")){
            fase = bundle.getString("FASE4");
        }
        if(bundle.containsKey("FASE5")){
            fase = bundle.getString("FASE5");
        }
        if(bundle.containsKey("FASE6")){
            fase = bundle.getString("FASE6");
        }

        Display display = this.getWindowManager().getDefaultDisplay();

        try {
            gameView = new GameView(this, display.getWidth(), display.getHeight(),fase,this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setContentView(gameView);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyleGreenAndYellow);
        builder.setMessage("Deseja voltar ao menu de fases?")
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(getApplicationContext(), FasesActivity.class);
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


    public void showDialogFimdeFase(String mensagem, final int pontos) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyleGreenAndYellow);
        builder.setMessage(mensagem)
                .setCancelable(false)
                .setPositiveButton(R.string.voltar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        FileOutputStream outputStream;
                        try {
                            outputStream = openFileOutput("Teste.txt", MODE_APPEND);
                            System.out.println(pontos);
                            outputStream.write(pontos);
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(getApplicationContext(), FasesActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton(R.string.proxima, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showDialogFaseReprovada(String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyleGreenAndYellow);
        builder.setMessage(mensagem)
                .setCancelable(false)
                .setPositiveButton(R.string.voltar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(getApplicationContext(), FasesActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton(R.string.continuar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
