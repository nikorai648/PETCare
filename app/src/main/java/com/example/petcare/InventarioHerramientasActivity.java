package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InventarioHerramientasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fragment_inventario_herramientas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button btnAgregar = findViewById(R.id.btnAgregar);
        Button btnModificar = findViewById(R.id.btnModificar);
        Button btnEliminar = findViewById(R.id.btnEliminar);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InventarioHerramientasActivity.this, OpcionAgregarVeterinariaActivity.class);
                startActivity(intent);
            }
        });


        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InventarioHerramientasActivity.this, OpcionModificarVeterinariaActivity.class);
                startActivity(intent);
            }
        });


        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InventarioHerramientasActivity.this, OpcionEliminarVeterinariaActivity.class);
                startActivity(intent);
            }
        });
    }
}
