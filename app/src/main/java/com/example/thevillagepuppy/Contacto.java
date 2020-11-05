package com.example.thevillagepuppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Contacto extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        ImageView star = findViewById(R.id.ivFavoritos);

        star.setVisibility(View.INVISIBLE);

        Toolbar toolbar = findViewById(R.id.miactionbar);
        setSupportActionBar(toolbar);

        final EditText etNombre = (EditText) findViewById(R.id.etNombre);
        final EditText etEmail = (EditText) findViewById(R.id.etMail);
        final EditText etMensaje = (EditText) findViewById(R.id.etMensaje);
        final Button btnEnviar = (Button) findViewById(R.id.btEnviar);
        final TextView tvAlert = (TextView) findViewById(R.id.tvAlert);

        btnEnviar.setOnClickListener(view -> {
            /*
            String nombre = etNombre.getText().toString();
            String email = etEmail.getText().toString();
            String mensaje = etMensaje.getText().toString();
             */
            etNombre.setText("");
            etEmail.setText("");
            etMensaje.setText("");
            tvAlert.setText("Mensaje enviado!");
        });


    }
}