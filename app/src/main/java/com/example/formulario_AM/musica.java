package com.example.formulario_AM;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class musica extends AppCompatActivity {

    TextView txtInfo;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        txtInfo = findViewById(R.id.txtInfo);
        btnRegresar = findViewById(R.id.btnRegresar);

        SharedPreferences preferences = getSharedPreferences("MisDatos", MODE_PRIVATE);
        String nombre = preferences.getString("nombre", "");
        String edad = preferences.getString("edad", "");
        String categoria = preferences.getString("categoria", "");

        txtInfo.setText("Nombre: " + nombre + "\nEdad: " + edad + "\nCategoría: " + categoria);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}