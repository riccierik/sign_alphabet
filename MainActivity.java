package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int CAMERA_REQUEST = 100;
    private Button bttContinua = null;

    private int colorSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bttContinua = findViewById(R.id.bttContinua);
        bttContinua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newActivity();
            }

            public void newActivity(){
                verifyPermissions();
                Intent activity2Intent = new Intent(getApplicationContext(),Translator.class);
                activity2Intent.putExtra("colore", colorSelected);
                startActivity(activity2Intent);
            }

        });
    }


    private void verifyPermissions(){
        Context context = this.getApplicationContext();
        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(context, "Per continuare devi concedere i permessi della Fotocamera!",
                    Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    CAMERA_REQUEST);
        }
    }

    public void onRadioButtonClickedGiallo(View view) {
        colorSelected = 1;
    }

    public void onRadioButtonClickedVerde(View view) {
        colorSelected = 2;
    }

    public void onRadioButtonClickedBlu(View view) {
        colorSelected = 3;
    }
}