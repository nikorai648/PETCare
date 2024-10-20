package com.example.petcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VeterinarioMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinario_menu);

        // Botón "Ver Registro de Clientes"
        Button btnVerRegistroClientes = findViewById(R.id.button3);
        btnVerRegistroClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VeterinarioMenuActivity.this, RegistroClienteparte1Activity.class);
                startActivity(intent);
            }
        });

        // Botón "Estados Actuales de Mascotas"
        Button btnEstadoMascotas = findViewById(R.id.button4);
        btnEstadoMascotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VeterinarioMenuActivity.this, RegistroClienteparte2Activity.class);
                startActivity(intent);
            }
        });

        // Botón "Ver Inventario de Veterinaria" ya no es necesario porque el submenú ya está aquí

        // Botones del submenú de inventario
        Button btnMedicamentos = findViewById(R.id.button17);
        Button btnHerramientas = findViewById(R.id.button18);
        Button btnComidaMascotas = findViewById(R.id.button19);
        Button btnOtrosProductos = findViewById(R.id.button20);

        // Navegación dentro del submenú de inventario
        btnMedicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VeterinarioMenuActivity.this, InventarioMedicamentosActivity.class);
                startActivity(intent);
            }
        });

        btnHerramientas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VeterinarioMenuActivity.this, InventarioHerramientasActivity.class);
                startActivity(intent);
            }
        });

        btnComidaMascotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VeterinarioMenuActivity.this, InvetarioComidaActivity.class);
                startActivity(intent);
            }
        });

        btnOtrosProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VeterinarioMenuActivity.this, InventarioOtrosProductosActivity.class);
                startActivity(intent);
            }
        });
    }
}
