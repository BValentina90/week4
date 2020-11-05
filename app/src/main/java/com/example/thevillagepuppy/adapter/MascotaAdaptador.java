package com.example.thevillagepuppy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thevillagepuppy.pojo.Mascota;
import com.example.thevillagepuppy.R;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascota, viewGroup, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int i) {
        final Mascota mascota = mascotas.get(i);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvCalificacion.setText(mascota.getRating());

        mascotaViewHolder.ivCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = parseInt(mascota.getRating()) +1;
                mascota.setRating(String.valueOf(count));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvCalificacion;
        private ImageView ivCalificar;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCalificacion = (TextView) itemView.findViewById(R.id.tvCalificacion);
            ivCalificar = (ImageView) itemView.findViewById(R.id.ivCalificar);
        }
    }
}