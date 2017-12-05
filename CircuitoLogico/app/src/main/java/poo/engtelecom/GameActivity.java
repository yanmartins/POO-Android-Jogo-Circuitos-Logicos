package poo.engtelecom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.AutoCompleteTextView;

import java.io.FileOutputStream;
import java.io.IOException;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    private Display display;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String fase = null;

        Bundle bundle = getIntent().getExtras();

        this.nome = bundle.getString("JOGADOR");

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

        display = this.getWindowManager().getDefaultDisplay();

        try {
            gameView = new GameView(this, display.getWidth(), display.getHeight(),fase, this);
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


    public void showDialogFimdeFase(String mensagem, int x, final String nomeFase) {
        FileOutputStream outputStream = null;
        String nomeText = (nome + ".txt");
        System.out.println(nomeText);
        try {
            outputStream = openFileOutput(nomeText, MODE_APPEND);
            String aux = String.valueOf(x);
            outputStream.write((nomeFase+ " ;" +aux+"\n").getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                .setNegativeButton(R.string.proxima, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(nomeFase.equals("fase1.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE2", "fase2.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase2.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE3", "fase3.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase3.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE4", "fase4.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase4.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE5", "fase5.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase5.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE6", "fase6.txt");
                            startActivity(intent);
                        }

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