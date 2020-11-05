package com.example.thevillagepuppy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.thevillagepuppy.adapter.PageAdapter;
import com.example.thevillagepuppy.fragments.ListaMascotasFragment;
import com.example.thevillagepuppy.fragments.PerfilFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        /*
        ImageView btnStar = findViewById(R.id.ivFavoritos);

        btnStar.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, MascotasFavoritas.class);
            startActivity(i);
        });

        Toolbar toolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itFavoritos:
                Intent iFavoritos = new Intent(this, MascotasFavoritas.class);
                startActivity(iFavoritos);
                break;
            case R.id.mContacto:
                Intent intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.mAcercade:
                Intent i = new Intent(this, Acercade.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @NonNull
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new ListaMascotasFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    public void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_face_);
    }
}