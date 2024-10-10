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

public class OpcionesMenuInventarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opciones_menu_inventario);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los botones
        Button btnMedicamentos = findViewById(R.id.button17);
        Button btnHerramientas = findViewById(R.id.button18);
        Button btnComidaMascotas = findViewById(R.id.button19);
        Button btnOtrosProductos = findViewById(R.id.button20);

        // Listener para el botón "Medicamentos"
        btnMedicamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcionesMenuInventarioActivity.this, InventarioMedicamentosActivity.class);
                startActivity(intent);
            }
        });

        // Listener para el botón "Herramientas"
        btnHerramientas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcionesMenuInventarioActivity.this, InventarioHerramientasActivity.class);
                startActivity(intent);
            }
        });

        // Listener para el botón "Comida Mascotas"
        btnComidaMascotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcionesMenuInventarioActivity.this, InvetarioComidaActivity.class);
                startActivity(intent);
            }
        });

        // Listener para el botón "Otros Productos"
        btnOtrosProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcionesMenuInventarioActivity.this, InventarioOtrosProductosActivity.class);
                startActivity(intent);
            }
        });
    }
}
