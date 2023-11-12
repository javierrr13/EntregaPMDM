package com.example.entregapmdm1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class Opciones extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);

        Intent intent = getIntent();
        String numString = intent.getStringExtra("num");
        int valorclick = intent.getIntExtra("valorclick", 1);
        int costoBillete = intent.getIntExtra("costoBillete", 100);

        BigInteger num = new BigInteger(numString);
        Button botonInformacion = findViewById(R.id.botonInformacion);
        botonInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Opciones.this, informacion.class);
                startActivity(intent);
            }
        });
        Button botonRanking = findViewById(R.id.botonRanking);
        botonRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rankingIntent = new Intent(Opciones.this, ranking.class);
                startActivity(rankingIntent);
            }
        });
        Button botonsultarMejoras = findViewById(R.id.botonConsultarMejoras);
        botonsultarMejoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultasIntent = new Intent(Opciones.this, Consultas.class);
                startActivity(consultasIntent);
            }
        });

    }
    public void RegresarMain(View view){
         finish();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
