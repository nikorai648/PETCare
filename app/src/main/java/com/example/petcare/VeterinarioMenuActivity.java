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

public class VeterinarioMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_veterinario_menu);

        // Ajustar ventanas para el modo Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
                // Redirigir a la actividad EstadosActualesMascotasActivity
                Intent intent = new Intent(VeterinarioMenuActivity.this, RegistroClienteparte2Activity.class);
                startActivity(intent);
            }
        });

        // Botón "Ver Inventario de Veterinaria"
        Button btnInventarioVeterinaria = findViewById(R.id.button5);
        btnInventarioVeterinaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a la actividad InventarioVeterinariaActivity
                Intent intent = new Intent(VeterinarioMenuActivity.this, OpcionesMenuInventarioActivity.class);
                startActivity(intent);
            }
        });

        // Botón "Llamado para Clientes"
        Button btnLlamadoClientes = findViewById(R.id.button6);
        btnLlamadoClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a la actividad LlamadoClientesActivity
                Intent intent = new Intent(VeterinarioMenuActivity.this, OpcionLLamadoClienteActivity.class);
                startActivity(intent);
            }
        });
    }
}
