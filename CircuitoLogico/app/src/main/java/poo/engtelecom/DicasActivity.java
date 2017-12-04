package poo.engtelecom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DicasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicas);
    }

    public void iniciarAndActivity(View view){
        Intent intent = new Intent(this, AndActivity.class);
        startActivity(intent);
    }

    public void iniciarOrActivity(View view){
        Intent intent = new Intent(this, OrActivity.class);
        startActivity(intent);
    }

    public void iniciarNotActivity(View view) {
        Intent intent = new Intent(this, NotActivity.class);
        startActivity(intent);
    }

    public void iniciarXorActivity(View view) {
        Intent intent = new Intent(this, XorActivity.class);
        startActivity(intent);
    }
}
