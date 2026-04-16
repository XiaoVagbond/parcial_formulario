package com.example.formulario_AM;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.parcial_formulario.R;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtEdad;
    Spinner spinnerCategoria;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = findViewById(R.id.edtNombre);
        edtEdad = findViewById(R.id.edtEdad);
        spinnerCategoria = findViewById(R.id.spinnerCategoria);
        btnGuardar = findViewById(R.id.btnGuardar);

        String[] categorias = {"Deportes", "Música", "Cine"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapter);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = edtNombre.getText().toString();
                String edad = edtEdad.getText().toString();
                String categoria = spinnerCategoria.getSelectedItem().toString();

                if (nombre.isEmpty() || edad.isEmpty()) {
                    Toast.makeText(MainActivity.this, "llene todlos campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences preferences = getSharedPreferences("misdatos", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nombre", nombre);
                editor.putString("edad", edad);
                editor.putString("categoria", categoria);
                editor.apply();


                if (categoria.equals("Deportes")) {
                    Intent intent = new Intent(MainActivity.this, deportes.class);
                    startActivity(intent);
                } else if (categoria.equals("Musica")) {
                    Intent intent = new Intent(MainActivity.this, musica.class);
                    startActivity(intent);
                } else if (categoria.equals("Cine")) {
                    Intent intent = new Intent(MainActivity.this, cine.class);
                    startActivity(intent);
                }
            }
        });
    }
}