package com.example.proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //boton registrate
    public void Registrate(View view){
        Intent registrate = new Intent(this, registerActivity.class);
        startActivity(registrate);
    }
    //boton inicio sesion
    public void Inicio_sesion(View view){
        Intent inicio_sesion = new Intent(this, appActivity2.class);
        startActivity(inicio_sesion);
    }
}