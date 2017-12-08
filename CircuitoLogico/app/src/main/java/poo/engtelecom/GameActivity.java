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
        if(bundle.containsKey("FASE7")){
            fase = bundle.getString("FASE7");
        }
        if(bundle.containsKey("FASE8")){
            fase = bundle.getString("FASE8");
        }
        if(bundle.containsKey("FASE9")){
            fase = bundle.getString("FASE9");
        }
        if(bundle.containsKey("FASE10")){
            fase = bundle.getString("FASE10");
        }
        if(bundle.containsKey("FASE11")){
            fase = bundle.getString("FASE11");
        }
        if(bundle.containsKey("FASE12")){
            fase = bundle.getString("FASE12");
        }
        if(bundle.containsKey("FASE13")){
            fase = bundle.getString("FASE13");
        }
        if(bundle.containsKey("FASE14")){
            fase = bundle.getString("FASE14");
        }
        if(bundle.containsKey("FASE15")){
            fase = bundle.getString("FASE15");
        }
        if(bundle.containsKey("FASE16")){
            fase = bundle.getString("FASE16");
        }
        if(bundle.containsKey("FASE17")){
            fase = bundle.getString("FASE17");
        }
        if(bundle.containsKey("FASE18")){
            fase = bundle.getString("FASE18");
        }
        if(bundle.containsKey("FASE19")){
            fase = bundle.getString("FASE19");
        }
        if(bundle.containsKey("FASE20")){
            fase = bundle.getString("FASE20");
        }
        if(bundle.containsKey("FASE21")){
            fase = bundle.getString("FASE21");
        }
        if(bundle.containsKey("FASE22")){
            fase = bundle.getString("FASE22");
        }
        if(bundle.containsKey("FASE23")){
            fase = bundle.getString("FASE23");
        }
        if(bundle.containsKey("FASE24")){
            fase = bundle.getString("FASE24");
        }
        if(bundle.containsKey("FASE25")){
            fase = bundle.getString("FASE25");
        }
        if(bundle.containsKey("FASE26")){
            fase = bundle.getString("FASE26");
        }
        if(bundle.containsKey("FASE27")){
            fase = bundle.getString("FASE27");
        }
        if(bundle.containsKey("FASE28")){
            fase = bundle.getString("FASE28");
        }
        if(bundle.containsKey("FASE29")){
            fase = bundle.getString("FASE29");
        }
        if(bundle.containsKey("FASE30")){
            fase = bundle.getString("FASE30");
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
                        if(nomeFase.equals("fase6.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE7", "fase7.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase7.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE8", "fase8.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase8.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE9", "fase9.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase9.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE10", "fase10.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase10.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE11", "fase11.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase11.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE12", "fase12.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase12.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE13", "fase13.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase13.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE14", "fase14.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase14.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE15", "fase15.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase15.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE16", "fase16.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase16.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE17", "fase17.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase17.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE18", "fase18.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase18.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE19", "fase19.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase19.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE20", "fase20.txt");
                            startActivity(intent);
                        }if(nomeFase.equals("fase20.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE21", "fase21.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase21.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE22", "fase22.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase22.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE23", "fase23.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase23.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE24", "fase24.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase24.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE25", "fase25.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase25.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE26", "fase26.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase26.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE27", "fase27.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase27.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE28", "fase28.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase28.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE29", "fase29.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase29.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE30", "fase30.txt");
                            startActivity(intent);
                        }
                        if(nomeFase.equals("fase30.txt")) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            intent.putExtra("FASE12", "fase12.txt");
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