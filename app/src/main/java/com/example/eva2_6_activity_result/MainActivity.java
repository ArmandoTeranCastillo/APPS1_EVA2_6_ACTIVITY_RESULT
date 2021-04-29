package com.example.eva2_6_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int CODIGO_SEGUN = 1000;

    Button btnIniSecun;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,Secundaria.class);
    }
    protected void onStart(){
        super.onStart();
        btnIniSecun = findViewById(R.id.btnIniSecun);
        btnIniSecun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent,CODIGO_SEGUN);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /* Procesar respuesta de la actividad
        *  1.Identificar la actividad que devolvio el resultado
        *  2.Identificar si devolvió un valor o no
        *  Leer los datos (intent)
        *  */
        switch (requestCode){
            case CODIGO_SEGUN:
                if(resultCode == Activity.RESULT_OK){ //Si me devolvió un valor
                    //Leer los datos
                    Toast.makeText(this, data.getStringExtra("VALOR"),Toast.LENGTH_LONG).show();
                }
            break;
            //Un case para cada actividad que devuelve un valor
            default:
        }

    }
}