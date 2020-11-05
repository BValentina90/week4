package com.example.thevillagepuppy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.example.thevillagepuppy.R;
import com.example.thevillagepuppy.adapter.MascotaAdaptador;
import com.example.thevillagepuppy.pojo.Mascota;

public class ListaMascotasFragment extends Fragment {

    private RecyclerView listaMascotas;

    ArrayList<Mascota> mascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);

        listaMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotasFavoritas();
        inicializarAdaptador();

        // Inflate the layout for this fragment
        return v;
    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotasFavoritas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Kacique", "48", R.drawable.indio));
        mascotas.add(new Mascota("Soldier", "37", R.drawable.soldado));
        mascotas.add(new Mascota("Cawdog", "25", R.drawable.gaucho));
        mascotas.add(new Mascota("Constructor", "16", R.drawable.bombero));
        mascotas.add(new Mascota("Police", "5", R.drawable.policia));

    }
}