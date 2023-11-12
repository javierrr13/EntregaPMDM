package com.example.entregapmdm1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Consultas extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultas);
    }
    public void RegresarOpciones(View v){
        Intent intent = new Intent(this, Opciones.class);
        startActivity(intent);
    }
}
