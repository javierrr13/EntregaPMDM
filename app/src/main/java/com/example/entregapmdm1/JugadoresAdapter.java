package com.example.entregapmdm1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JugadoresAdapter extends RecyclerView.Adapter<JugadorViewHolder> {
    Context context;
    List<Jugador> jugadores;
    public JugadoresAdapter(Context context ,List<Jugador> jugadores) {
        this.context=context;
        this.jugadores=jugadores;
    }

    @NonNull
    @Override
    public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JugadorViewHolder(LayoutInflater.from(context).inflate(R.layout.rankingvista,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {
        holder.nick.setText(jugadores.get(position).getNick());
        holder.monedas.setText(jugadores.get(position).getMonedas());
        holder.imagen.setImageResource(jugadores.get(position).getImagen());

    }

    @Override
    public int getItemCount() {
        return jugadores.size();
    }
}
