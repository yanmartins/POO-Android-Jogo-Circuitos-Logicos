package poo.engtelecom;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by mello on 14/11/17.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarGameActivity(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void iniciarScoreActivity(View view){
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

    public void iniciarDicasActivity(View view){
        Intent intent = new Intent(this, DicasActivity.class);
        startActivity(intent);
    }

    //public void iniciarFasesActivity(View view){
    //    Intent intent = new Intent(this, FasesActivity.class);
    //    startActivity(intent);
    //}

    public void iniciarNovoJogadorActivity(View view){
        Intent intent = new Intent(this, NovoJogadorActivity.class);
        startActivity(intent);
    }

    public void continuarActivity(View view){
        Intent intent = new Intent(this, ContinuarActivity.class);
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyleGreenAndYellow);
        builder.setMessage(R.string.dialog_game_exit)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
