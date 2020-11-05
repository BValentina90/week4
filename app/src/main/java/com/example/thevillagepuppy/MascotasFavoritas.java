package com.example.thevillagepuppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import com.example.thevillagepuppy.adapter.MascotaAdaptador;
import com.example.thevillagepuppy.pojo.Mascota;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasfav;
    private RecyclerView listaMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        ImageView star = findViewById(R.id.ivFavoritos);
        star.setVisibility(View.INVISIBLE);

        Toolbar toolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaMascotasFav = (RecyclerView) findViewById(R.id.rvTop5);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(llm);
        iniciarListaMascotasFav();
        iniciarAdaptadorFav();
    }

    public void iniciarAdaptadorFav(){
        MascotaAdaptador adaptadorfav = new MascotaAdaptador(mascotasfav);
        listaMascotasFav.setAdapter(adaptadorfav);
    }

    public void iniciarListaMascotasFav() {
        mascotasfav = new ArrayList<Mascota>();

        mascotasfav.add(new Mascota("Kacique", "46", R.drawable.indio));
        mascotasfav.add(new Mascota("Constructor","35", R.drawable.bombero));
        mascotasfav.add(new Mascota("Police","24", R.drawable.policia));
        mascotasfav.add(new Mascota("Soldier","13", R.drawable.soldado));
        mascotasfav.add(new Mascota("Cawdog","02", R.drawable.gaucho));
    }
}