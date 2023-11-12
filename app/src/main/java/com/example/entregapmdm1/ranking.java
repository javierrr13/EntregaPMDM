package com.example.entregapmdm1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ranking extends AppCompatActivity {
    ArrayList<Jugador> jugadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);

        jugadores.add(new Jugador("pepe","21334",R.drawable.a));
        jugadores.add(new Jugador("Alberto","32434",R.drawable.ccc));

        RecyclerView rv = findViewById(R.id.recycler);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new JugadoresAdapter(getApplicationContext(),jugadores));
    }
    public void RegresarOpciones(View v){
        Intent intent = new Intent(this, Opciones.class);
        startActivity(intent);
    }
}
